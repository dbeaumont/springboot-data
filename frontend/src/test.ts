// Ce fichier est requis par karma.conf.js et charge récursivement tous les fichiers .spec et les fichiers du framework

import 'zone.js/testing';
import { getTestBed } from '@angular/core/testing';
import {
  BrowserDynamicTestingModule,
  platformBrowserDynamicTesting
} from '@angular/platform-browser-dynamic/testing';

declare const require: {
  context(path: string, deep?: boolean, filter?: RegExp): {
    keys(): string[];
    <T>(id: string): T;
  };
};

// D'abord, initialiser l'environnement de test Angular
getTestBed().initTestEnvironment(
  BrowserDynamicTestingModule,
  platformBrowserDynamicTesting(), {
    teardown: { destroyAfterEach: false }
  }
);

// Ensuite, nous trouvons tous les tests
const context = require.context('./', true, /\.spec\.ts$/);
// Et chargeons les modules
context.keys().forEach(context);
