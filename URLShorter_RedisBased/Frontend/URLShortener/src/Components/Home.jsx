// Home.js
import  { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { logout, getUser } from '../services/authService'


export const Home = () => {
    const navigate = useNavigate();
    const [url, setUrl] = useState('');
    const [ttl, setTtl] = useState('60');
    const [shortedUrl, setShortedUrl] = useState('New Url');
   
  const handleSubmit = async (event) => {
    event.preventDefault();

    try {
      const response = await fetch('http://localhost:8181/re', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({ url, ttl })
      });

      if (!response.ok) {
        throw new Error('Network response was not ok');
      }

      const data = await response.json();
      setShortedUrl(data.shortedurl)
      console.log('Response from server:', data);
    } catch (error) {
      console.error('Error:', error.message);
    }
  };

    const handleLogout = () => {
      logout();
      navigate('/login');
    };
  
    const user = getUser();
  
    return (
        <>
    
        <div className="card mx-auto mt-5" style={{ maxWidth: '30rem' }}>
          <div className="card-body">
          <p className="card-title text-center mb-4"> Welcome, {user.username}!</p>
            <h2 className="card-title text-center mb-4">URL Shortener</h2>
            <form onSubmit={handleSubmit}>
              <div className="mb-3">
                <label htmlFor="url" className="form-label">URL</label>
                <input
                  type="url"
                  className="form-control"
                  id="url"
                  name="url"
                  value={url}
                  onChange={(e) => setUrl(e.target.value)}
                  required
                />
              </div>
              <div className="mb-3">
                <label htmlFor="ttl" className="form-label">TTL (in seconds)</label>
                <input
                  type="number"
                  className="form-control"
                  id="ttl"
                  name="ttl"
                  value={ttl}
                  onChange={(e) => setTtl(e.target.value)}
                  required
                />
              </div>
              <button type="submit" className="btn btn-primary">Shorten URL</button>
            </form>
            <br/>
            <input
                  type="url"
                  className="form-control"
                  id="shortedUrl"
                  name="shortedUrl"
                  value={shortedUrl}
                  onChange={(e) => setUrl(e.target.value)}
                  required
                />
          </div>
        </div>
        <div className="text-center mt-3">
          <button onClick={handleLogout} className="btn btn-outline-danger">Logout</button>
        </div>
      </>
        
    );
}
