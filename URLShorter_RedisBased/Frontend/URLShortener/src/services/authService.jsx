// authService.js
let user = null;

export const login = (username, password) => {
  // In a real application, you would fetch from an API
  if (username === "admin" && password === "password") {
    user = { username };
    return true;
  }
  return false;
};

export const logout = () => {
  user = null;
};

export const isAuthenticated = () => {
  return user !== null;
};

export const getUser = () => {
  return user;
};
