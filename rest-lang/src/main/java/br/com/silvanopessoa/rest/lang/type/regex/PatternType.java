/******************************************************************************
 * Produto: REST                                                              *
 *                                                                            *
 *    History:                                                                *
 *          Data        Programador              Tarefa                       *
 *          ----------  -----------------        -----------------------------*
 *   Autor  05/06/2015  silvano.pessoa          Classe criada.                *
 *                                                                            *
 *   Comments:                                                                *
 *                                                                            *
 *                                                                            *
 *****************************************************************************/
package br.com.silvanopessoa.rest.lang.type.regex;

/**
 * Classe com constantes de regex.
 *
 * @author silvano.pessoa
 *
 */
public final class PatternType {

    /**
     * Construtor da Classe.
     *
     */
    private PatternType() {
    }

    /** Define qual é o padrão de email a ser informado. */
    public static final String EMAIL = "([a-z0-9_-]([a-z0-9-_\\.]*[a-z0-9-_])*)@([a-z0-9\\.-]*[a-z0-9]\\.(arpa|root|aero|biz|cat|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|net|org|pro|tel|travel|ac|ad|ae|af|ag|ai|al|am|an|ao|aq|ar|as|at|au|aw|ax|az|ba|bb|bd|be|bf|bg|bh|bi|bj|bm|bn|bo|br|bs|bt|bv|bw|by|bz|ca|cc|cd|cf|cg|ch|ci|ck|cl|cm|cn|co|cr|cu|cv|cx|cy|cz|de|dj|dk|dm|do|dz|ec|ee|eg|er|es|et|eu|fi|fj|fk|fm|fo|fr|ga|gb|gd|ge|gf|gg|gh|gi|gl|gm|gn|gp|gq|gr|gs|gt|gu|gw|gy|hk|hm|hn|hr|ht|hu|id|ie|il|im|in|io|iq|ir|is|it|je|jm|jo|jp|ke|kg|kh|ki|km|kn|kr|kw|ky|kz|la|lb|lc|li|lk|lr|ls|lt|lu|lv|ly|ma|mc|md|mg|mh|mk|ml|mm|mn|mo|mp|mq|mr|ms|mt|mu|mv|mw|mx|my|mz|na|nc|ne|nf|ng|ni|nl|no|np|nr|nu|nz|om|pa|pe|pf|pg|ph|pk|pl|pm|pn|pr|ps|pt|pw|py|qa|re|ro|ru|rw|sa|sb|sc|sd|se|sg|sh|si|sj|sk|sl|sm|sn|so|sr|st|su|sv|sy|sz|tc|td|tf|tg|th|tj|tk|tl|tm|tn|to|tp|tr|tt|tv|tw|tz|ua|ug|uk|um|us|uy|uz|va|vc|ve|vg|vi|vn|vu|wf|ws|ye|yt|yu|za|zm|zw)|([0-9]{1,3}\\.{3}[0-9]{1,3}))";

    /** A Constante TELEFONE. */
    public static final String TELEFONE = "\\d{8,11}";

    /** A Constante CODIGO_ACESSO. */
    public static final String CODIGO_ACESSO = "\\d{12}";

    /** A Constante NATUREZA_JURIDICA_TYPE. */
    public static final String NATUREZA_JURIDICA_TYPE = "\\d{3}-\\d";

    /** A Constante SUFRAMA. */
    public static final String SUFRAMA = "\\d{2}\\d{3}\\d{3}\\d{1}";

    /** A Constante CNAE. */
    public static final String CNAE = "\\d{7}";

    /** A Constante CEP. */
    public static final String CEP = "\\d{8}";

    /** A Constante CRC. */
    public static final String CRC = "[A-Z]{2}\\d{5,6}[OP]";

    /** A Constante DMED. */
    public static final String DMED = "\\d{7}";

    /** A Constante UF. */
    public static final String UF = "[A-Z][A-Z]";

    /** A Constante SERIE_ARMA. */
    public static final String SERIE_ARMA = "\\w{9}";

    /** A Constante SERIE_CANO. */
    public static final String SERIE_CANO = "\\w{9}";

    /** A Constante RAZAOSOCIAL. */
    public static final String RAZAOSOCIAL = "[A-Z a-záéíóúàèìòùãõâêîôûüïçÁÉÍÓÚÀÈÌÒÙÂÊÎÔÛÃÕÜÏÇ0-9-']{1,100}";

    /** A Constante NOMEFANTASIA. */
    public static final String NOMEFANTASIA = "[A-Z a-záéíóúàèìòùãõâêîôûüïçÁÉÍÓÚÀÈÌÒÙÂÊÎÔÛÃÕÜÏÇ0-9-']{1,100}";

    /** A Constante INSCRICAOESTADUAL. */
    public static final String INSCRICAOESTADUAL = "(\\W|^)ISENTO(\\W|$)|[0-9]{14}";

    /** A Constante PESSOA_FISICA_NOME. */
    public static final String PESSOA_FISICA_NOME = "[A-Z a-záéíóúàèìòùãõâêîôûüïçÁÉÍÓÚÀÈÌÒÙÂÊÎÔÛÃÕÜÏÇ0-9-']{2,100}";

    /** A Constante PESSOA_ESTRANGEIRA_CODIGO_REGISTRO_INTERNACIONAL. */
    public static final String PESSOA_ESTRANGEIRA_CODIGO_REGISTRO_INTERNACIONAL = "[A-Z a-z0-9]{1,60}";

    /** A Constante PESSOA_AUTONOMA_NOME. */
    public static final String PESSOA_AUTONOMA_NOME = "[A-Z a-záéíóúàèìòùãõâêîôûüïçÁÉÍÓÚÀÈÌÒÙÂÊÎÔÛÃÕÜÏÇ0-9-']{2,100}";

    /** A Constante RAZAO_SOCIAL_COMPLETA. */
    public static final String RAZAO_SOCIAL_COMPLETA = "[A-Z a-záéíóúàèìòùãõâêîôûüïçÁÉÍÓÚÀÈÌÒÙÂÊÎÔÛÃÕÜÏÇ0-9-']{2,255}";

    /** A Constante SIGLA_UNIDADE_MEDIDA. */
    public static final String SIGLA_UNIDADE_MEDIDA = "([^.áéíóúàèìòùãõâêîôûüïçÁÉÍÓÚÀÈÌÒÙÂÊÎÔÛÃÕÜÏÇ-])*([A-Za-z0-9]){1,4}";

    /** A Constante DESCRICAO_UNIDADE_MEDIDA. */
    public static final String DESCRICAO_UNIDADE_MEDIDA = "[A-Z a-záéíóúàèìòùãõâêîôûüïçÁÉÍÓÚÀÈÌÒÙÂÊÎÔÛÃÕÜÏÇ 0-9 -]{2,30}";

    /** A Constante CODIGO_UNIDADE_MEDIDA. */
    public static final String CODIGO_UNIDADE_MEDIDA = "([^.áéíóúàèìòùãõâêîôûüïçÁÉÍÓÚÀÈÌÒÙÂÊÎÔÛÃÕÜÏÇ-])*([A-Za-z0-9]){1,14}";

    /** A Constante CODIF_COMBUSTIVEL. */
    public static final String CODIF_COMBUSTIVEL = "\\d{1,21}";

    /** A Constante NUMERO_LOTE_MEDICAMENTO. */
    public static final String NUMERO_LOTE_MEDICAMENTO = "[^|;]{1,20}";

    /** A Constante URL. */
    public static final String URL = "\\b(https?|ftp|file)://[-A-Z0-9+&@#/%?=~_|!:,.;]*[-A-Z0-9+&@#/%=~_|]";

    /** A Constante CODIGO_IBGE. */
    public static final String CODIGO_IBGE = "([0-9]){7}";

    /** A Constante CHASSI. */
    public static final String CHASSI = "\\d{17}";

    /** A Constante CODIGO_MARCA_MODELO. */
    public static final String CODIGO_MARCA_MODELO = "\\d{1,6}";

    /** A Constante PINTURA. */
    public static final String PINTURA = "\\d{1}";

    /** A Constante NUMERO_MOTOR. */
    public static final String NUMERO_MOTOR = "\\d{21}";

    /** A Constante PIPE_AND_SEMICOLON. */
    public static final String PIPE_AND_SEMICOLON = "[A-Z a-záéíóúàèìòùãõâêîôûüïçÁÉÍÓÚÀÈÌÒÙÂÊÎÔÛÃÕÜÏÇ 0-9 -./_@]{0,5000}";

    /** A Constante NUM. */
    public static final String NUM = "[0-9 -./_()]{0,5000}";

    /** A Constante ALPHANUM. */
    public static final String ALPHANUM = "[A-Z a-z 0-9]{0,5000}";

    /** A Constante RG. */
    public static final String RG = "(?:[A-Za-z0-9]{6,9})?";

    /** A Constante SENHA_USUARIO. */
    public static final String SENHA_USUARIO = "[^\\s]*";

    /** A Constante SENHA_OAUTH_CLIENT. */
    public static final String SENHA_OAUTH_CLIENT = "[A-Za-z0-9-]{0,}";

    /** A Constante SITE. */
    public static final String SITE = "[^\\s]*";

    /** A Constante APELIDO_CLIENTE. */
    public static final String APELIDO_CLIENTE = "[a-z0-9]{1,30}";
    
    public static final String NOME_GRUPO = "[A-Z0-9\\_]{1,120}";

    /** A Constante LOGIN_USUARIO. */
    public static final String LOGIN_USUARIO = "[a-z0-9]{1,}@[a-z0-9]{1,}";

    /** A Constante NOME_USUARIO. */
    public static final String NOME_USUARIO = "[[A-Za-zÀ-ú]?((\\s([A-Za-zÀ-ú])))*]{1,60}";
    
    /** A Constante IP. */
    public static final String IP = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

}
