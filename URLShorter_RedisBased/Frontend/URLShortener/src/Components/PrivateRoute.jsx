// PrivateRoute.js
import { Navigate } from 'react-router-dom';
import { isAuthenticated } from '../services/authService';

const PrivateRoute = ({ component: Component }) => {
    return isAuthenticated() ? <Component /> : <Navigate to="/login" />;
  };
  

export default PrivateRoute;
