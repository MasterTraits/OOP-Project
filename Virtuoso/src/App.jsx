import { BrowserRouter, Route, Routes } from "react-router-dom"
import EmployeeDashboard from "./pages/EmployeeDashboard"
import RegistrationForm from "./pages/Auth/RegistrationForm"
import Add from "./pages/Add"

function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<EmployeeDashboard/>} />
          <Route path="/employeedashboard" element={<EmployeeDashboard/>} />
          <Route path="/register" element={<RegistrationForm/>} />
          <Route path="/add-employee" element={<Add />} />
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
