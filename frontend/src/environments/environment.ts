// Ce fichier peut être remplacé pendant le build en utilisant le fichier `fileReplacements` array.
// `ng build` remplace `environment.ts` par `environment.prod.ts`.
// La liste des remplacements de fichiers se trouve dans `angular.json`.

export const environment = {
  production: false,
  apiUrl: 'http://localhost:4200/backend/api',
  version: '1.0.0-dev',
  buildDate: new Date().toISOString(),
  // Configuration pour le développement local
  logLevel: 'debug',
  enableDebugTools: true,
  mockApiCalls: false,
  // Timeout pour les requêtes HTTP (en ms)
  requestTimeout: 30000
};

/*
 * Pour faciliter le débogage en mode développement, vous pouvez importer le fichier suivant
 * pour ignorer les erreurs liées à la zone comme `zone.run`, `zoneDelegate.invokeTask`.
 *
 * Cette import devrait être commenté en production car il aura un impact négatif
 * sur les performances si une erreur est levée.
 */
// import 'zone.js/plugins/zone-error';  // Included with Angular CLI.
