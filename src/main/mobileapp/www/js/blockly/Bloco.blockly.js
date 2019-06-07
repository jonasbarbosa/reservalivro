window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Bloco = window.blockly.js.blockly.Bloco || {};

/**
 * Bloco
 */
window.blockly.js.blockly.Bloco.Executar = function() {
 var item;
  this.blockly.js.blockly.auth.Login.login('admin', 'admin', null);
  this.cronapi.screen.changeView("#/app/logged/home",[  ]);
}
