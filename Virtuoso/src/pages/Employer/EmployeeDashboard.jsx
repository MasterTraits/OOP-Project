import {
  Home,
  Inbox,
  History,
  User,
  Search,
  UserPlus,
  XCircle,
  Pen
} from "lucide-react";
import { Button } from "@/components/ui/button";
import { Table, TableBody, TableCell, TableRow } from "../../components/ui/table";
import { Checkbox } from "@/components/ui/checkbox";
import { Link }  from "react-router-dom"
import { useState } from "react";

export default function EmployeeDashboard() {
  const [showCheckBox, setShowCheckBox] = useState(false); 

  return (
    <div className="flex flex-col justify-start p-2 bg-[#F6F7FB] font-sans overflow-x-hidden">
      <header className="flex justify-between items-center p-4 bg-transparent">
        <div className="title-container">
          <h1 className="text-[28px] font-bold text-[#444] font-montserrat leading-none tracking-[-1.1px]">
            Your <br /> Employees
          </h1>
        </div>
        <Button className="w-[78px] h-[34px] rounded-full bg-[#7FB68B] text-white text-center font-montserrat text-base font-bold">
          HELP  
        </Button>
      </header>
      <main className="flex-1 flex flex-col items-center justify-start gap-6 p-4 mt-4">
        <Button className="w-full h-[46px] rounded-[20px] bg-gradient-to-br from-[#FFC067] to-[#699773] shadow-md text-white text-center font-montserrat text-base font-semibold tracking-[-0.64px]">
          Set Workplace & Contract
        </Button>
        <div className="flex gap-4 justify-center">
          <Button
            variant="outline" 
            size="icon"
            className="w-[47px] h-[46px] rounded-[10px] bg-white shadow-sm"
          >
            <Search className="h-6 w-6" />
          </Button>
          <Link
            variant="outline"
            to="/employer/add-employee"
            className="w-[135px] h-[46px] rounded-[10px] border hover:bg-neutral-100 bg-white shadow-sm flex justify-center items-center gap-2 text-[#444] font-montserrat text-sm font-medium"
          >
            <UserPlus className="h-5 w-5" />
            Add
          </Link>
          <Button
            onClick={() => setShowCheckBox(!showCheckBox)}  
            variant="outline"
            className="w-[100px] h-[46px] rounded-[10px] bg-white shadow-sm flex justify-center items-center gap-2 text-[#444] font-montserrat text-sm font-medium"
          >
            <XCircle className="h-5 w-5" />
            {showCheckBox ? "Cancel" : "Remove"}
          </Button>
        </div>
        <Table>
          <TableBody className='odd:bg-white even:bg-slate-50'>
            {/* MAKE THIS INTO A ID CLASS */}
            <TableRow>
              <TableCell className="hover:bg-neutral-100 flex items-center justify-between">
                  <Link 
                    to="/employer/conversation"
                    className="flex items-center"
                  >
                    {showCheckBox && <Checkbox onClick={(e) => e.preventDefault()} className="mr-3 h-5 w-5" />}
                    <img src="" className="mr-4 h-14 w-14 rounded-full bg-black"/>
                    <div className="leading-3">
                      <span className="text-xs">Type</span>
                      <h1 className="text-lg">Name</h1>
                      <p>Message here</p>
                    </div>
                  </Link>
                  <Link 
                    to="/employer/update-employee"
                    className="p-2 rounded-full bg-neutral-200 hover:bg-slate-300"
                    >
                      <Pen className="h-5 w-5"/>
                  </Link>
              </TableCell>
            </TableRow>
          </TableBody>
        </Table>
      </main>
      <div className="fixed bottom-0 left-0 right-0 bg-[#f6f7fb] p-4 shadow-md rounded-t-[40px]">
          <div className="flex justify-around max-w-md mx-auto">
            {[
              { icon: Home, label: "Home" },
              { icon: Inbox, label: "Inbox" },
              { icon: History, label: "History" },
              { icon: User, label: "Profile" },
            ].map(({ icon: Icon, label }) => (
              <div key={label} className="flex flex-col items-center">
                <Icon className="h-8 w-8" />
                <span className="text-sm mt-1">{label}</span>
              </div>
            ))}
          </div>
        </div>
    </div>
  );
}
