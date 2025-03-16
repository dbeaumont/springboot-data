export const environment = {
    production: true,
    apiUrl: 'http://localhost:4200/backend/api',
    version: '1.0.0',
    buildDate: new Date().toISOString(),
    // Configuration pour la production
    logLevel: 'true',  // 'false',
    enableDebugTools: false,
    mockApiCalls: false,
    // Timeout pour les requêtes HTTP (en ms)
    requestTimeout: 60000
  };
  