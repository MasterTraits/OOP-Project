import {
  Home,
  Inbox,
  History,
  User,
  Search,
  UserPlus,
  XCircle,
} from "lucide-react";
import { Button } from "@/components/ui/button";
import { Table, TableBody, TableCell, TableRow } from "../components/ui/table";

export default function EmployeeDashboard() {
  return (
    <div className="flex flex-col justify-start w-[393px] h-[852px] bg-[#F6F7FB] font-sans">
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
        <Button className="w-[342px] h-[46px] rounded-[20px] bg-gradient-to-br from-[#FFC067] to-[#699773] shadow-md text-white text-center font-montserrat text-base font-semibold tracking-[-0.64px]">
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
          <Button
            variant="outline"
            className="w-[135px] h-[46px] rounded-[10px] bg-white shadow-sm flex justify-center items-center gap-2 text-[#444] font-montserrat text-sm font-medium"
          >
            <UserPlus className="h-5 w-5" />
            Add
          </Button>
          <Button
            variant="outline"
            className="w-[100px] h-[46px] rounded-[10px] bg-white shadow-sm flex justify-center items-center gap-2 text-[#444] font-montserrat text-sm font-medium"
          >
            <XCircle className="h-5 w-5" />
            Remove
          </Button>
        </div>
        <Table>
          <TableBody>
            <TableRow>
              <TableCell>John Doe</TableCell>
            </TableRow>
            <TableRow>
              <TableCell>Jane Smith</TableCell>
            </TableRow>
            <TableRow>
              <TableCell>Michael Johnson</TableCell>
            </TableRow>
            <TableRow>
              <TableCell>Emily Davis</TableCell>
            </TableRow>
            <TableRow>
              <TableCell>William Brown</TableCell>
            </TableRow>
          </TableBody>
        </Table>
      </main>
      <footer className="flex justify-around items-center bg-white p-2 shadow-[0_-2px_4px_rgba(0,0,0,0.1)] rounded-[50px]">
        <div className="flex flex-col items-center text-sm text-[#444444] gap-[-0.20rem] cursor-pointer">
          <Home className="h-6 w-6" />
          <p>Home</p>
        </div>
        <div className="flex flex-col items-center text-sm text-[#444444] gap-[-0.20rem] cursor-pointer">
          <Inbox className="h-6 w-6" />
          <p>Inbox</p>
        </div>
        <div className="flex flex-col items-center text-sm text-[#444444] gap-[-0.20rem] cursor-pointer">
          <History className="h-6 w-6" />
          <p>History</p>
        </div>
        <div className="flex flex-col items-center text-sm text-[#444444] gap-[-0.20rem] cursor-pointer">
          <User className="h-6 w-6" />
          <p>Profile</p>
        </div>
      </footer>
    </div>
  );
}
