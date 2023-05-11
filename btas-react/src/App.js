
import React from "react";
import './css/App.css';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";

import Profile from "./components/Events";

function App() {
  return (
    <div className="App">
      <header className="App-header">
        Event History Checking
      </header>
      <Profile />
    </div>
  );
}


export default App;