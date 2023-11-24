import React,{Fragment} from 'react';
import { BrowserRouter as Router,Route,Routes } from 'react-router-dom';
import Loging from './paginas/auth/Login';
import CrearCuenta from './paginas/auth/CrearCuenta';
import Home from './paginas/auth/Home';


function App() {
  return (
    <Fragment>
      <Router>
        <Routes>
          <Route path="/" exact element={<Loging/>}/>
          <Route path="/crear-cuenta" exact element={<CrearCuenta/>}/>
          <Route path="/home" exact element={<Home/>}/>
        </Routes>
      </Router>
    </Fragment>
  );
}

export default App;
