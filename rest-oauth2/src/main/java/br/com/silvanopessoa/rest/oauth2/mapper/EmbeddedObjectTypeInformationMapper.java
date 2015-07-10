/*
 * Copyright 2011-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.silvanopessoa.rest.oauth2.mapper;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.Embeddable;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.convert.MappingContextTypeInformationMapper;
import org.springframework.data.convert.TypeInformationMapper;
import org.springframework.data.mapping.PersistentEntity;
import org.springframework.data.mapping.context.MappingContext;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.util.ClassTypeInformation;
import org.springframework.data.util.TypeInformation;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

/**
 * {@link TypeInformationMapper} implementation that can be either set up using a {@link MappingContext} or manually set up {@link Map} of {@link String} aliases to types. If a {@link MappingContext}
 * is used the {@link Map} will be build inspecting the {@link PersistentEntity} instances for type alias information.
 */
public class EmbeddedObjectTypeInformationMapper implements TypeInformationMapper {

    /** O(a)(s) type map. */
    private final Map<ClassTypeInformation<?>, Object> typeMap;

    /** O(a)(s) base package. */
    private final String[] basePackage;

    /**
     * Creates a {@link MappingContextTypeInformationMapper} from the given {@link MappingContext}. Inspects all {@link PersistentEntity} instances for alias information and builds a {@link Map} of
     * aliases to types from it.
     * 
     * @param mappingContext must not be {@literal null}.
     * @throws ClassNotFoundException
     */
    public EmbeddedObjectTypeInformationMapper(String... basePackage) throws ClassNotFoundException {
        Assert.notNull(basePackage);
        this.basePackage = basePackage;
        Map<? extends Class<?>, String> initialEntitySet = getInitialEntitySet();
        this.typeMap = new HashMap<ClassTypeInformation<?>, Object>(initialEntitySet.size());
        for(Entry<? extends Class<?>, String> entry : initialEntitySet.entrySet()) {
            ClassTypeInformation<?> key = ClassTypeInformation.from(entry.getKey());
            String value = entry.getValue();

            if (typeMap.containsValue(value)) {
                throw new IllegalArgumentException(String.format("Detected mapping ambiguity! String %s cannot be mapped to more than one type!", value));
            }

            this.typeMap.put(key, value);
        }

    }

    /**
     * Scans the mapping base package for classes annotated with {@link Embeddable}.
     * 
     * @return
     * @throws ClassNotFoundException
     */
    protected final Map<Class<?>, String> getInitialEntitySet() throws ClassNotFoundException {
        String[] basePackageList = this.basePackage;
        Map<Class<?>, String> initialEntitySet = new HashMap<Class<?>, String>();
        if (basePackageList != null) {
            for(String packageBase : basePackageList) {
                if (StringUtils.hasText(packageBase)) {
                    ClassPathScanningCandidateComponentProvider componentProvider = new ClassPathScanningCandidateComponentProvider(false);
                    componentProvider.addIncludeFilter(new AnnotationTypeFilter(Embeddable.class));
                    this.addInitialEntitySet(componentProvider, packageBase, initialEntitySet);
                }
            }
        }
        return initialEntitySet;
    }

    /**
     * Adds the initial entity set.
     *
     * @param componentProvider O(a)(s) component provider
     * @param packageBase O(a)(s) package base
     * @param initialEntitySet O(a)(s) initial entity set
     * @throws ClassNotFoundException the class not found exception
     */
    private void addInitialEntitySet(ClassPathScanningCandidateComponentProvider componentProvider, String packageBase, Map<Class<?>, String> initialEntitySet) throws ClassNotFoundException{
        for(BeanDefinition candidate : componentProvider.findCandidateComponents(packageBase)) {
            Class<?> forName = ClassUtils.forName(candidate.getBeanClassName(), AbstractMongoConfiguration.class.getClassLoader());
            String alias = forName.getAnnotation(TypeAlias.class) != null ? forName.getAnnotation(TypeAlias.class).value() : forName.getName();
            initialEntitySet.put(forName, alias);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.data.convert.TypeInformationMapper#createAliasFor(org.springframework.data.util.TypeInformation)
     */
    @Override
    public Object createAliasFor(TypeInformation<?> type) {
        return typeMap.get(type);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.data.convert.TypeInformationMapper#resolveTypeFrom(java.lang.Object)
     */
    @Override
    public ClassTypeInformation<?> resolveTypeFrom(Object alias) {
        if (alias == null) {
            return null;
        }
        for(Entry<ClassTypeInformation<?>, Object> entry : typeMap.entrySet()) {
            if (entry.getValue().equals(alias)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
