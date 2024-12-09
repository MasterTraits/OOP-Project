import { createContext, useState } from 'react';

export const UserContext = createContext();

export const UserProvider = ({ children }) => {
  const [auth, setAuth] = useState(true);
  const [employer, setEmployer] = useState(true);

  return (
    <UserContext.Provider value={{ auth, setAuth, employer, setEmployer }}>
      {children}
    </UserContext.Provider>
  );
}
