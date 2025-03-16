/**
 * Ce fichier inclut les polyfills nécessaires pour Angular et est chargé avant l'application.
 * Vous pouvez ajouter vos propres polyfills supplémentaires à ce fichier.
 *
 * Ce fichier est divisé en 2 sections :
 *   1. Polyfills du navigateur. Ces polyfills sont appliqués avant de charger ZoneJS et sont triés par navigateurs.
 *   2. Polyfills d'application. Importez ces polyfills après avoir chargé ZoneJS (mais avant l'application).
 */

/***************************************************************************************************
 * POLYFILLS DU NAVIGATEUR
 */

/**
 * Par défaut, zone.js corrigera toutes les macrotâches possibles, mais cela peut avoir des conséquences sur les performances :
 * https://github.com/angular/angular/issues/20764. Pour désactiver les correctifs de zone.js pour certaines macrotâches
 * qui ne nécessitent pas de stabilisation de microtâche (la plupart des requêtes XHR, les événements DOM...),
 * utilisez la directive ci-dessous avant d'importer zone.js.
 * Importez la directive zone.js après avoir chargé le polyfill.
 */
// (window as any).__Zone_disable_requestAnimationFrame = true; // disable patch requestAnimationFrame
// (window as any).__Zone_disable_on_property = true; // disable patch onProperty such as onclick
// (window as any).__zone_symbol__UNPATCHED_EVENTS = ['scroll', 'mousemove']; // disable patch specified eventNames

/**
 * Zone JS est requis par Angular lui-même.
 */
import 'zone.js';  // Inclus avec Angular CLI.

/***************************************************************************************************
 * POLYFILLS D'APPLICATION
 */

/**
 * Si votre application a besoin de polyfills supplémentaires, comme intl, 
 * vous pouvez les ajouter ici.
 */

// import 'core-js/features/array/find';
// import 'core-js/features/array/includes';
// import 'core-js/features/number/is-nan';

/**
 * Support pour les navigateurs qui n'ont pas certaines fonctionnalités ES2015+
 * Décommentez les lignes selon les besoins
 */

// import 'core-js/es/symbol';
// import 'core-js/es/object';
// import 'core-js/es/function';
// import 'core-js/es/parse-int';
// import 'core-js/es/parse-float';
// import 'core-js/es/number';
// import 'core-js/es/math';
// import 'core-js/es/string';
// import 'core-js/es/date';
// import 'core-js/es/array';
// import 'core-js/es/regexp';
// import 'core-js/es/map';
// import 'core-js/es/weak-map';
// import 'core-js/es/set';

/**
 * Support pour les applications Web progressives
 */
// import 'whatwg-fetch';
