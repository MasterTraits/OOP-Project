import path from "path";
import { app, BrowserWindow } from "electron";
import { fileURLToPath } from "url";

function createWindow() {
  const mainWindow = new BrowserWindow({
    width: 420,
    height: 852,
    autoHideMenuBar: true,
    resizable: false,
    webPreferences: {
      contextIsolation: true,
    },
  });

  mainWindow.loadURL('http://localhost:5173');
  // mainWindow.loadFile('index.html');
}

app.on('ready', createWindow);

app.on('window-all-closed', () => {
  if (process.platform !== 'darwin') {
    app.quit();
  }
});