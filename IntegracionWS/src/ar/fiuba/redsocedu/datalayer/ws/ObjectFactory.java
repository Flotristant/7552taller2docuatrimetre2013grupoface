
package ar.fiuba.redsocedu.datalayer.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ar.fiuba.redsocedu.datalayer.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CommitResponse_QNAME = new QName("http://ws.datalayer.redsocedu.fiuba.ar/", "commitResponse");
    private final static QName _MiembroChat_QNAME = new QName("http://ws.datalayer.redsocedu.fiuba.ar/", "miembroChat");
    private final static QName _Ambito_QNAME = new QName("http://ws.datalayer.redsocedu.fiuba.ar/", "ambito");
    private final static QName _QueryResponse_QNAME = new QName("http://ws.datalayer.redsocedu.fiuba.ar/", "queryResponse");
    private final static QName _Tema_QNAME = new QName("http://ws.datalayer.redsocedu.fiuba.ar/", "tema");
    private final static QName _SaveOrUpdateResponse_QNAME = new QName("http://ws.datalayer.redsocedu.fiuba.ar/", "saveOrUpdateResponse");
    private final static QName _Mensaje_QNAME = new QName("http://ws.datalayer.redsocedu.fiuba.ar/", "mensaje");
    private final static QName _Foro_QNAME = new QName("http://ws.datalayer.redsocedu.fiuba.ar/", "foro");
    private final static QName _Cartelera_QNAME = new QName("http://ws.datalayer.redsocedu.fiuba.ar/", "cartelera");
    private final static QName _SaveOrUpdate_QNAME = new QName("http://ws.datalayer.redsocedu.fiuba.ar/", "saveOrUpdate");
    private final static QName _Curso_QNAME = new QName("http://ws.datalayer.redsocedu.fiuba.ar/", "curso");
    private final static QName _DeleteResponse_QNAME = new QName("http://ws.datalayer.redsocedu.fiuba.ar/", "deleteResponse");
    private final static QName _ReturnedObject_QNAME = new QName("http://ws.datalayer.redsocedu.fiuba.ar/", "returnedObject");
    private final static QName _Alumno_QNAME = new QName("http://ws.datalayer.redsocedu.fiuba.ar/", "alumno");
    private final static QName _Seccion_QNAME = new QName("http://ws.datalayer.redsocedu.fiuba.ar/", "seccion");
    private final static QName _BeginTransaction_QNAME = new QName("http://ws.datalayer.redsocedu.fiuba.ar/", "beginTransaction");
    private final static QName _Rollback_QNAME = new QName("http://ws.datalayer.redsocedu.fiuba.ar/", "rollback");
    private final static QName _Evento_QNAME = new QName("http://ws.datalayer.redsocedu.fiuba.ar/", "evento");
    private final static QName _Chat_QNAME = new QName("http://ws.datalayer.redsocedu.fiuba.ar/", "chat");
    private final static QName _Usuario_QNAME = new QName("http://ws.datalayer.redsocedu.fiuba.ar/", "usuario");
    private final static QName _Query_QNAME = new QName("http://ws.datalayer.redsocedu.fiuba.ar/", "query");
    private final static QName _BeginTransactionResponse_QNAME = new QName("http://ws.datalayer.redsocedu.fiuba.ar/", "beginTransactionResponse");
    private final static QName _Noticia_QNAME = new QName("http://ws.datalayer.redsocedu.fiuba.ar/", "noticia");
    private final static QName _MensajeChat_QNAME = new QName("http://ws.datalayer.redsocedu.fiuba.ar/", "mensajeChat");
    private final static QName _Subforo_QNAME = new QName("http://ws.datalayer.redsocedu.fiuba.ar/", "subforo");
    private final static QName _Delete_QNAME = new QName("http://ws.datalayer.redsocedu.fiuba.ar/", "delete");
    private final static QName _Muro_QNAME = new QName("http://ws.datalayer.redsocedu.fiuba.ar/", "muro");
    private final static QName _Commit_QNAME = new QName("http://ws.datalayer.redsocedu.fiuba.ar/", "commit");
    private final static QName _RollbackResponse_QNAME = new QName("http://ws.datalayer.redsocedu.fiuba.ar/", "rollbackResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ar.fiuba.redsocedu.datalayer.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BeginTransactionResponse }
     * 
     */
    public BeginTransactionResponse createBeginTransactionResponse() {
        return new BeginTransactionResponse();
    }

    /**
     * Create an instance of {@link MensajeChat }
     * 
     */
    public MensajeChat createMensajeChat() {
        return new MensajeChat();
    }

    /**
     * Create an instance of {@link Noticia }
     * 
     */
    public Noticia createNoticia() {
        return new Noticia();
    }

    /**
     * Create an instance of {@link Usuario }
     * 
     */
    public Usuario createUsuario() {
        return new Usuario();
    }

    /**
     * Create an instance of {@link Query }
     * 
     */
    public Query createQuery() {
        return new Query();
    }

    /**
     * Create an instance of {@link Evento }
     * 
     */
    public Evento createEvento() {
        return new Evento();
    }

    /**
     * Create an instance of {@link Rollback }
     * 
     */
    public Rollback createRollback() {
        return new Rollback();
    }

    /**
     * Create an instance of {@link Chat }
     * 
     */
    public Chat createChat() {
        return new Chat();
    }

    /**
     * Create an instance of {@link Seccion }
     * 
     */
    public Seccion createSeccion() {
        return new Seccion();
    }

    /**
     * Create an instance of {@link Alumno }
     * 
     */
    public Alumno createAlumno() {
        return new Alumno();
    }

    /**
     * Create an instance of {@link BeginTransaction }
     * 
     */
    public BeginTransaction createBeginTransaction() {
        return new BeginTransaction();
    }

    /**
     * Create an instance of {@link RollbackResponse }
     * 
     */
    public RollbackResponse createRollbackResponse() {
        return new RollbackResponse();
    }

    /**
     * Create an instance of {@link Commit }
     * 
     */
    public Commit createCommit() {
        return new Commit();
    }

    /**
     * Create an instance of {@link Delete }
     * 
     */
    public Delete createDelete() {
        return new Delete();
    }

    /**
     * Create an instance of {@link Muro }
     * 
     */
    public Muro createMuro() {
        return new Muro();
    }

    /**
     * Create an instance of {@link Subforo }
     * 
     */
    public Subforo createSubforo() {
        return new Subforo();
    }

    /**
     * Create an instance of {@link Foro }
     * 
     */
    public Foro createForo() {
        return new Foro();
    }

    /**
     * Create an instance of {@link Cartelera }
     * 
     */
    public Cartelera createCartelera() {
        return new Cartelera();
    }

    /**
     * Create an instance of {@link SaveOrUpdate }
     * 
     */
    public SaveOrUpdate createSaveOrUpdate() {
        return new SaveOrUpdate();
    }

    /**
     * Create an instance of {@link QueryResponse }
     * 
     */
    public QueryResponse createQueryResponse() {
        return new QueryResponse();
    }

    /**
     * Create an instance of {@link Tema }
     * 
     */
    public Tema createTema() {
        return new Tema();
    }

    /**
     * Create an instance of {@link SaveOrUpdateResponse }
     * 
     */
    public SaveOrUpdateResponse createSaveOrUpdateResponse() {
        return new SaveOrUpdateResponse();
    }

    /**
     * Create an instance of {@link Mensaje }
     * 
     */
    public Mensaje createMensaje() {
        return new Mensaje();
    }

    /**
     * Create an instance of {@link CommitResponse }
     * 
     */
    public CommitResponse createCommitResponse() {
        return new CommitResponse();
    }

    /**
     * Create an instance of {@link MiembroChat }
     * 
     */
    public MiembroChat createMiembroChat() {
        return new MiembroChat();
    }

    /**
     * Create an instance of {@link Ambito }
     * 
     */
    public Ambito createAmbito() {
        return new Ambito();
    }

    /**
     * Create an instance of {@link DeleteResponse }
     * 
     */
    public DeleteResponse createDeleteResponse() {
        return new DeleteResponse();
    }

    /**
     * Create an instance of {@link ReturnedObject }
     * 
     */
    public ReturnedObject createReturnedObject() {
        return new ReturnedObject();
    }

    /**
     * Create an instance of {@link Curso }
     * 
     */
    public Curso createCurso() {
        return new Curso();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommitResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.datalayer.redsocedu.fiuba.ar/", name = "commitResponse")
    public JAXBElement<CommitResponse> createCommitResponse(CommitResponse value) {
        return new JAXBElement<CommitResponse>(_CommitResponse_QNAME, CommitResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MiembroChat }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.datalayer.redsocedu.fiuba.ar/", name = "miembroChat")
    public JAXBElement<MiembroChat> createMiembroChat(MiembroChat value) {
        return new JAXBElement<MiembroChat>(_MiembroChat_QNAME, MiembroChat.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Ambito }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.datalayer.redsocedu.fiuba.ar/", name = "ambito")
    public JAXBElement<Ambito> createAmbito(Ambito value) {
        return new JAXBElement<Ambito>(_Ambito_QNAME, Ambito.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.datalayer.redsocedu.fiuba.ar/", name = "queryResponse")
    public JAXBElement<QueryResponse> createQueryResponse(QueryResponse value) {
        return new JAXBElement<QueryResponse>(_QueryResponse_QNAME, QueryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Tema }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.datalayer.redsocedu.fiuba.ar/", name = "tema")
    public JAXBElement<Tema> createTema(Tema value) {
        return new JAXBElement<Tema>(_Tema_QNAME, Tema.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveOrUpdateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.datalayer.redsocedu.fiuba.ar/", name = "saveOrUpdateResponse")
    public JAXBElement<SaveOrUpdateResponse> createSaveOrUpdateResponse(SaveOrUpdateResponse value) {
        return new JAXBElement<SaveOrUpdateResponse>(_SaveOrUpdateResponse_QNAME, SaveOrUpdateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Mensaje }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.datalayer.redsocedu.fiuba.ar/", name = "mensaje")
    public JAXBElement<Mensaje> createMensaje(Mensaje value) {
        return new JAXBElement<Mensaje>(_Mensaje_QNAME, Mensaje.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Foro }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.datalayer.redsocedu.fiuba.ar/", name = "foro")
    public JAXBElement<Foro> createForo(Foro value) {
        return new JAXBElement<Foro>(_Foro_QNAME, Foro.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Cartelera }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.datalayer.redsocedu.fiuba.ar/", name = "cartelera")
    public JAXBElement<Cartelera> createCartelera(Cartelera value) {
        return new JAXBElement<Cartelera>(_Cartelera_QNAME, Cartelera.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveOrUpdate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.datalayer.redsocedu.fiuba.ar/", name = "saveOrUpdate")
    public JAXBElement<SaveOrUpdate> createSaveOrUpdate(SaveOrUpdate value) {
        return new JAXBElement<SaveOrUpdate>(_SaveOrUpdate_QNAME, SaveOrUpdate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Curso }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.datalayer.redsocedu.fiuba.ar/", name = "curso")
    public JAXBElement<Curso> createCurso(Curso value) {
        return new JAXBElement<Curso>(_Curso_QNAME, Curso.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.datalayer.redsocedu.fiuba.ar/", name = "deleteResponse")
    public JAXBElement<DeleteResponse> createDeleteResponse(DeleteResponse value) {
        return new JAXBElement<DeleteResponse>(_DeleteResponse_QNAME, DeleteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReturnedObject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.datalayer.redsocedu.fiuba.ar/", name = "returnedObject")
    public JAXBElement<ReturnedObject> createReturnedObject(ReturnedObject value) {
        return new JAXBElement<ReturnedObject>(_ReturnedObject_QNAME, ReturnedObject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Alumno }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.datalayer.redsocedu.fiuba.ar/", name = "alumno")
    public JAXBElement<Alumno> createAlumno(Alumno value) {
        return new JAXBElement<Alumno>(_Alumno_QNAME, Alumno.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Seccion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.datalayer.redsocedu.fiuba.ar/", name = "seccion")
    public JAXBElement<Seccion> createSeccion(Seccion value) {
        return new JAXBElement<Seccion>(_Seccion_QNAME, Seccion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BeginTransaction }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.datalayer.redsocedu.fiuba.ar/", name = "beginTransaction")
    public JAXBElement<BeginTransaction> createBeginTransaction(BeginTransaction value) {
        return new JAXBElement<BeginTransaction>(_BeginTransaction_QNAME, BeginTransaction.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Rollback }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.datalayer.redsocedu.fiuba.ar/", name = "rollback")
    public JAXBElement<Rollback> createRollback(Rollback value) {
        return new JAXBElement<Rollback>(_Rollback_QNAME, Rollback.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Evento }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.datalayer.redsocedu.fiuba.ar/", name = "evento")
    public JAXBElement<Evento> createEvento(Evento value) {
        return new JAXBElement<Evento>(_Evento_QNAME, Evento.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Chat }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.datalayer.redsocedu.fiuba.ar/", name = "chat")
    public JAXBElement<Chat> createChat(Chat value) {
        return new JAXBElement<Chat>(_Chat_QNAME, Chat.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Usuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.datalayer.redsocedu.fiuba.ar/", name = "usuario")
    public JAXBElement<Usuario> createUsuario(Usuario value) {
        return new JAXBElement<Usuario>(_Usuario_QNAME, Usuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Query }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.datalayer.redsocedu.fiuba.ar/", name = "query")
    public JAXBElement<Query> createQuery(Query value) {
        return new JAXBElement<Query>(_Query_QNAME, Query.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BeginTransactionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.datalayer.redsocedu.fiuba.ar/", name = "beginTransactionResponse")
    public JAXBElement<BeginTransactionResponse> createBeginTransactionResponse(BeginTransactionResponse value) {
        return new JAXBElement<BeginTransactionResponse>(_BeginTransactionResponse_QNAME, BeginTransactionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Noticia }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.datalayer.redsocedu.fiuba.ar/", name = "noticia")
    public JAXBElement<Noticia> createNoticia(Noticia value) {
        return new JAXBElement<Noticia>(_Noticia_QNAME, Noticia.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MensajeChat }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.datalayer.redsocedu.fiuba.ar/", name = "mensajeChat")
    public JAXBElement<MensajeChat> createMensajeChat(MensajeChat value) {
        return new JAXBElement<MensajeChat>(_MensajeChat_QNAME, MensajeChat.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Subforo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.datalayer.redsocedu.fiuba.ar/", name = "subforo")
    public JAXBElement<Subforo> createSubforo(Subforo value) {
        return new JAXBElement<Subforo>(_Subforo_QNAME, Subforo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Delete }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.datalayer.redsocedu.fiuba.ar/", name = "delete")
    public JAXBElement<Delete> createDelete(Delete value) {
        return new JAXBElement<Delete>(_Delete_QNAME, Delete.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Muro }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.datalayer.redsocedu.fiuba.ar/", name = "muro")
    public JAXBElement<Muro> createMuro(Muro value) {
        return new JAXBElement<Muro>(_Muro_QNAME, Muro.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Commit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.datalayer.redsocedu.fiuba.ar/", name = "commit")
    public JAXBElement<Commit> createCommit(Commit value) {
        return new JAXBElement<Commit>(_Commit_QNAME, Commit.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RollbackResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.datalayer.redsocedu.fiuba.ar/", name = "rollbackResponse")
    public JAXBElement<RollbackResponse> createRollbackResponse(RollbackResponse value) {
        return new JAXBElement<RollbackResponse>(_RollbackResponse_QNAME, RollbackResponse.class, null, value);
    }

}
