import { BrowserRouter, Route, Routes } from "react-router-dom"
import { useContext } from "react"
import { UserContext } from "./pages/UserContext"
import { pdfjs } from 'react-pdf';

pdfjs.GlobalWorkerOptions.workerSrc = new URL(
  'pdfjs-dist/build/pdf.worker.min.mjs',
  import.meta.url,
).toString();

// AUTH SIDE
import Landing from "./pages/Landing"
import RegistrationForm from "./pages/Auth/RegistrationForm"
import LoginForm from "./pages/Auth/LoginForm"

// EMPLOYEE SIDE
import EmployeeDashboard from "./pages/Employee/EmployeeDashboard"
import Leave from "./pages/Employee/Leave"

// EMPLOYER SIDE
import EmployerDashboard from "./pages/Employer/EmployerDashboard"
import Add from "./pages/Employer/Add"
import { UpdateEmployee, ChatInterface } from "./pages/Employer/EmployerDashboard"
import ChatEmployee from "./pages/Employee/Chat"

function App() {
  const { auth, employer } = useContext(UserContext);

  return (
    <>
      <BrowserRouter>
        <Routes>
          {/* Auth Side */}
          {/* { !auth ? ( 
            <> { /* AUTHENTICATION SIDE TO ACCESS */ } 
              <Route path="/" element={<Landing />} />  
              <Route path="/register" element={<RegistrationForm/>} />
              <Route path="/login" element={<LoginForm/>} />
            {/* </>
          ) : (
            !employer ? ( 
              <> { /* EMPLOYEE SIDE TO ACCESS */ } 
                <Route path="/employee" element={<EmployeeDashboard/>} />
                <Route path="/employee/conversation" element={<ChatEmployee />} />
                <Route path="/employee/leave" element={<Leave />} />
              {/* </>
            ) : ( 
              <> { /* EMPLOYER SIDE TO ACCESS */ }
                <Route path="/employer" element={<EmployerDashboard/>} />
                <Route path="/employer/add-employee" element={<Add />} />
                <Route path="/employer/update-employee" element={<UpdateEmployee />} />
                <Route path="/employer/conversation" element={<ChatInterface />} />
              {/* </>
            )
          )} */}
          </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
