import { BrowserRouter, Route, Routes } from "react-router-dom"
import EmployeeDashboard from "./pages/Employer/EmployeeDashboard"
import RegistrationForm from "./pages/Auth/RegistrationForm"
import Add from "./pages/Employer/Add"
import Update from "./pages/Employer/Update"
import Chat from "./pages/Employer/Chat"
import { useState } from "react"

function App() {
  const [auth, setAuth] = useState(true)
  const [employer, setEmployer] = useState(true)

  return (
    <>
      <BrowserRouter>
          {/* Auth Side */}
          { !auth ? ( 
          // AUTHENTICATION SIDE TO ACCESS
          <Routes>
            <Route path="/" element={<RegistrationForm/>} />  {/* Default Route */}
            <Route path="/register" element={<RegistrationForm/>} />
          </Routes>
          ) : (
            !employer ? ( 
            // EMPLOYEE SIDE TO ACCESS
              "Employee Side"
            ) : ( 
            // EMPLOYER SIDE TO ACCESS
              <Routes>
                <Route path="/employer" element={<EmployeeDashboard/>} />
                <Route path="/employer/add-employee" element={<Add />} />
                <Route path="/employer/update-employee" element={<Update />} />
                <Route path="/employer/conversation" element={<Chat />} />
              </Routes>
            )
          )}
      </BrowserRouter>
    </>
  )
}

export default App
