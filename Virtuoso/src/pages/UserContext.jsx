import { createContext, useState } from 'react';

export const UserContext = createContext();

export const UserProvider = ({ children }) => {
  const [auth, setAuth] = useState(false);
  const [employer, setEmployer] = useState(false);

  return (
    <UserContext.Provider value={{ auth, setAuth, employer, setEmployer }}>
      {children}
    </UserContext.Provider>
  );
}
