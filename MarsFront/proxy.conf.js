const PROXY_CONFIG = [
  {
    context: ['/rest'],
    target: 'http://localhost:8081/',
    secure: false,
    loglevel: 'debug'
  }
];

module.exports = PROXY_CONFIG;