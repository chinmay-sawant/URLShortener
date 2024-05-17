
import { Route, Routes } from 'react-router-dom'
import './App.css'
import { Home } from './Components/Home'
import { Login } from './Components/Login'
import PrivateRoute from './Components/PrivateRoute'
// index.js or App.js
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.min.js';

function App() {
 
  return (
<>
      <Routes>
        <Route path="/login" element={<Login />} />
        <Route path="/home" element={<PrivateRoute component={Home} />} />
        <Route path="/" element={<Login />} />
      </Routes>

</>
  )
}

export default App
