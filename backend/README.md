# Séquence d'appel

```
Controller -> Service -> Port -> Adapter -> Repository -> Base de données
↑                                           ↓
└───────────────── Réponse ────────────────┘
```



```
Application
    public class MessageService {
        private final MessagePort messagePort;

Bootstrap
    public class MessageApplication {


Domain
    Message
    public interface MessagePort {

Infrastructure

    public class MessageAdapter implements MessagePort {
        private final MessageRepository repository;
        private final MessageMapper mapper;
    public class MessageMapper {
    public class MessageEntity {
    public class MessageController {
        private final MessageService dataService;
    public interface MessageRepository extends JpaRepository<MessageEntity, Long> {



```

```
Test du CORS :
# Test d'accès autorisé
curl -H "Origin: http://localhost:4200" -v http://localhost:8080/api/message

# Test d'accès refusé
curl -H "Origin: http://site-non-autorise.com" -v http://localhost:8080/api/message
```