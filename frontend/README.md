# Résolution pb CORS

# Description du problème
Le serveur web NGinX du container frontend sert l'application angular à l'utilisateur
L'application s'exécute donc dans le navigateur de l'utilisateur
Le pb de CORS vient de l'application angular sur le navigateur qui essaye d'accéder à l'url de http://backend:8080
Ca ne marchera pas car 'backend' n'est pas connu du navigateur

# Résolution du problème
Pour résoudre le pb de CORS, il faut utiliser le serveur web NGINX portant l'application angular comme un reverse proxy pour les invocations d'url
Au lieu que ce soit le browser qui invoque l'api externe, l'api est réexposée sur NGINX qui la redirige à son niveau vers le serveur externe
Ainsi, du point de vue du browser il n'y a pas eu de cross domain