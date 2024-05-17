
// Login.js
import  { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { login } from '../services/authService'


export const Login = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');
  const navigate = useNavigate();

  const handleSubmit = (e) => {
    e.preventDefault();
    if (login(username, password)) {
      navigate('/home');
    } else {
      setError('Invalid username or password');
    }
  };

  return (
    <div className="card mx-auto mt-5" style={{ maxWidth: '30rem' }}>
    <div className="card-body">
      <h2 className="card-title text-center mb-4">Login Page</h2>
      {error && <p className="text-danger">{error}</p>}
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label htmlFor="username" className="form-label">Username:</label>
          <input
            type="text"
            className="form-control"
            id="username"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            required
          />
        </div>
        <div className="mb-3">
          <label htmlFor="password" className="form-label">Password:</label>
          <input
            type="password"
            className="form-control"
            id="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
        </div>
        <button type="submit" className="btn btn-primary btn-block">Login</button>
      </form>
    </div>
  </div>
  );
};
