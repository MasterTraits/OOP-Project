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
import { useState, useEffect } from "react";
import instance from "@/lib/axiosConfig";
import { FaArrowRight } from 'react-icons/fa';
import { IoReorderThreeOutline } from "react-icons/io5";
import { BsPaperclip } from "react-icons/bs";
import { BsSendArrowDown } from "react-icons/bs";
import Mic from "@/assets/Mic";
import { Calendar } from "@/components/ui/calendar";
import { Card, CardContent } from "@/components/ui/card";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue,
} from "@/components/ui/select";


export default function EmployerDashboard() {
  const [showCheckBox, setShowCheckBox] = useState(false); 
  const [showEmployee, setShowEmployee] = useState([]);

  useEffect(() => {
    instance.get("/auth/users/employees")
    .then((response) => {
      setShowEmployee(response.data);
    })
    .catch((error) => {
      console.log(error);
    });
  }, []);

  const handleDelete = () => {
    const selectedEmployees = showEmployee.filter(employee => employee.isSelected);
    selectedEmployees.forEach(employee => {
      instance.delete(`/auth/users/employees/${employee.id}`)
        .then(() => {
          setShowEmployee(prevEmployees => prevEmployees.filter(e => e.id !== employee.id));
        })
        .catch((error) => {
          console.log(error);
        });
    });
  };

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
            {showEmployee.map((employee) => (
              <TableRow key={employee.id}>
                <TableCell className="hover:bg-neutral-100 flex items-center justify-between">
                  <div className="flex items-center">
                    {showCheckBox && (
                      <Checkbox
                        className="mr-3 h-5 w-5"
                      />
                    )}
                    <Link 
                      to={`/employer/conversation/`}
                      className="flex items-center"
                    >
                      <img src={employee.avatar} className="mr-4 h-14 w-14 rounded-full bg-black"/>
                      <div className="leading-3">
                        <span className="text-xs">{employee.job_title}</span>
                        <h1 className="text-lg">{employee.first_name}&nbsp;{employee.last_name}</h1>
                        {!employee.message ?  (<p className="text-neutral-500">No messages</p>) : (<p>{employee.message}</p>)}
                      </div>
                    </Link>
                  </div>
                  <Link 
                    to="/employer/update-employee"
                    className="p-2 rounded-full bg-neutral-200 hover:bg-slate-300"
                  >
                    <Pen className="h-5 w-5"/>
                  </Link>
                </TableCell>
              </TableRow>
            ))}
        
            </TableBody>
            </Table>
            </main>

            {showCheckBox && (
              <Button 
              // onClick={handleDelete}
                className="fixed bottom-28 left-1/2 transform -translate-x-1/2 w-3/4 bg-red-500 text-white transition-opacity duration-300 opacity-100">
                Delete
              </Button>
            )}
            {/* Bottom Navigation */}
      <div className="fixed bottom-0 left-0 right-0 bg-[#f6f7fb] p-4 shadow-md rounded-t-[40px]">
          <div className="flex justify-around max-w-md mx-auto">
            {[  
              { icon: Home, label: "Home", isActive: true },
              { icon: Inbox, label: "Inbox", isActive: false },
              { icon: History, label: "History", isActive: false },
              { icon: User, label: "Profile", isActive: false },
            ].map(({ icon: Icon, label, isActive }) => (
              <div key={label} className={`flex flex-col ${isActive ? 'text-blue-500' : ''} items-center`}>
                <Icon className="h-8 w-8" />
                <span className="text-sm mt-1">{label}</span>
              </div>
            ))}
          </div>
        </div>
    </div>
  );
}



function DateComponent() {
  const [currentDateTime, setCurrentDateTime] = useState('');

  useEffect(() => {
    const now = new Date();
    const options = { month: 'short', day: 'numeric' };
    const date = now.toLocaleDateString(undefined, options);
    const time = now.toLocaleTimeString(undefined, { hour: '2-digit', minute: '2-digit', hour12: true });
    setCurrentDateTime(`${date}, ${time}`);
  }, []);

  return <span className="text-header font-bold my-0">{currentDateTime}</span>;
}

export function ChatInterface() {
  const [input, setInput] = useState('');
  const [showResult, setShowResult] = useState(false);
  const [conversationHistory, setConversationHistory] = useState([]);

  const toggleSidebar = () => {
  };

  const handleNewChat = () => {
    setShowResult(false);
  };

  return (
    <>
    <main className="h-screen overflow-hidden bg-background text-black p-2 z-0">
        <>
          <header className='flex items-center justify-between bg-gray-800 p-4'>
            <div className='flex items-center mr-10'>
              <button onClick={toggleSidebar} className='bg-btnGray rounded-full p-[5px] text-white mr-5'>
                <IoReorderThreeOutline className='text-3xl text-black' />
              </button>

              <span className='flex flex-col ml-2 my-0 space-y-0'>
                <h1 className='text-header tracking-tighter font-bold my-0'>{"Name"}</h1>
                <DateComponent />
              </span>
            </div>

            <span className='ml-auto flex gap-3 items-center'>
              <button className="bg-btnGray rounded-full p-[5px] text-white" onClick={handleNewChat}>
              </button>
              <Link 
                to="/employer"
                className="bg-btnGray rounded-full p-[5px] text-white"
              >
                <FaArrowRight className='text-2xl text-black font-semibold' />
              </Link>
            </span>
          </header>

          {/* Main Chat Section */}
          <section className="h-screen bg-background px-5 py-3 items-center justify-center">
            <section className="w-full h-[calc(84vh-5rem)] overflow-y-scroll">
              {conversationHistory.map((message, index) => (
                <div 
                  key={index} 
                  className={`chat flex w-auto h-auto pb-3 mt-5 mr-3 ${
                    message.type === "user" ? "justify-end" : "justify-start"
                  }`}
                >
                  {message.type === "user" ? (
                    <div className="bg-gold text-white px-4 py-2 rounded-lg rounded-br-none max-w-[80%]">
                      <p>{message.text}</p>
                    </div>
                  ) : (
                    <div className="flex items-start w-full max-w-[95%]">
                    <div className="rounded-full w-[2.5rem] h-[2.5rem] p-[10px] mr-1 bg-header flex-shrink-0">
                    </div>
                      <div className="flex-1 bg-gray-200 px-4 py-2 rounded-lg rounded-bl-none">
                        Message here
                      </div>
                    </div>
                  )}
                </div>
              ))}
            </section>
          </section>

          {/* Footer Input */}
          <footer className="fixed bottom-10 w-full flex items-center justify-center">
            <section className="flex items-center gap-2">
              <div className="flex items-center bg-white rounded-3xl px-4 h-14 w-9/12 drop-shadow-[0_0_20px_rgb(0,0,0,0.25)]">
                <div className="flex gap-4 items-center w-full">
                  <div className="relative">
                    <BsPaperclip className="text-4xl text-header p-1 rounded-full bg-btnWhite" />
                    <input
                      type="file"
                      className="top-[-3%] absolute w-8 opacity-0"
                    />
                  </div>
                  <input
                    type="text"
                    value={input}
                    onChange={(e) => setInput(e.target.value)}
                    className="text-md w-full mr-2 focus:outline-none"
                    placeholder="Type here"
                    />
                </div>
                <Mic className="text-4xl text-header p-2.5 rounded-full bg-btnWhite" />
              </div>
              <button
                className="relative ml-2 h-14 w-14 rounded-full bg-gradient-to-br from-[#FFC067] to-[#699773]"
                >
                <BsSendArrowDown className="absolute text-3xl text-btnWhite top-3.5 left-2.5" />
              </button>
            </section>
          </footer>
        </>
    </main>
      </>
  );
} 


export function UpdateEmployee() {
  const [fieldsData, setFieldsData] = useState({
    firstName: '',
    lastName: '',
    job: '',
    contact: '',
    email: '',
    employmentType: '',
    payType: '',
    date: null,
  });

  const handleSubmit = (e) => {
    e.preventDefault();
    instance.put(`/auth/users/employees/${employeeId}`, fieldsData)
      .then((response) => {
        console.log('Employee updated successfully', response.data);
      })
      .catch((error) => {
        console.error('Error updating employee', error);
      });
  };

return (
  <div className="bg-[#f6f7fb]">
    <div className="pb-20 max-w-md mx-auto bg-[#f6f7fb]">
      {/* Header */}
      <div className="p-6 shadow-md">
        <div className="flex justify-between items-center mb-4">
        <h1 className="text-[28px] font-bold text-[#444] font-montserrat leading-none tracking-[-1.1px]">
          Update <br /> Employee
        </h1>
          <Link
            to="/employer"
            variant="secondary"
            className="py-1 px-4 bg-neutral-400 font-bold text-white rounded-full hover:bg-[#699773]"
          >
            Cancel
          </Link>
        </div>
      </div>

      <form onSubmit={handleSubmit} className="p-6 space-y-4">
        <div className="grid grid-cols-2 gap-2">
        <div>
          <Label className="text-sm text-[#717171]">Given Name *</Label>
          <Input
            type="text"
            placeholder="Juan Dela"
            required
            className="mt-1 border-[3px] border-[#adadad] rounded-[10px]"
            onChange={(e) => setFieldsData({ ...fieldsData, firstName: e.target.value })}
          />
        </div>
        <div>
          <Label className="text-sm text-[#717171]">Last Name *</Label>
          <Input
            type="text"
            placeholder="Cruz"
            required
            className="mt-1 border-[3px] border-[#adadad] rounded-[10px]"
            onChange={(e) => setFieldsData({ ...fieldsData, lasttName: e.target.value })}
          />
        </div>
        <div>
          <Label className="text-sm text-[#717171]">Job Title *</Label>
          <Input
            type="text"
            placeholder="Cook"
            required
            className="mt-1 border-[3px] border-[#adadad] rounded-[10px]"
            onChange={(e) => setFieldsData({ ...fieldsData, job: e.target.value })}
          />
        </div>
        <div>
          <Label className="text-sm text-[#717171]">Contact *</Label>
          <Input
            type="text"
            placeholder="+63 000 000 0000"
            required
            className="mt-1 border-[3px] border-[#adadad] rounded-[10px]"
            onChange={(e) => setFieldsData({ ...fieldsData, contact: e.target.value })}
          />
        </div>
        </div>

        <div className="col-span-2">
          <Label className="text-sm text-[#717171]">
            Email
          </Label>
          <Input
            placeholder="juandelacruz@gmail.com"
            className="mt-1 border-[3px] border-[#adadad] rounded-[10px]"
            onChange={(e) => setFieldsData({ ...fieldsData, email: e.target.value })}
          />
        </div>

        {/* Employee Type and Pay Type */}
        <div className="grid grid-cols-2 gap-4">
          <div>
            <Label className="text-sm text-[#717171]">Employee Type *</Label>
            <Select defaultValue="part-time">
              <SelectTrigger className="border-[3px] border-[#adadad] rounded-[10px]">
                <SelectValue placeholder="Select type" />
              </SelectTrigger>
              <SelectContent>
                <SelectItem value="part-time" onClick={() => setFieldsData({...fieldsData, employmentType: 'Part-time'})}>Part-time</SelectItem>
                <SelectItem value="full-time" onClick={() => setFieldsData({...fieldsData, employmentType: 'Full-time'})}>Full-time</SelectItem>
              </SelectContent>
            </Select>
          </div>
          <div>
            <Label className="text-sm text-[#717171]">Pay Type *</Label>
            <Select defaultValue="monthly">
              <SelectTrigger className="border-[3px] border-[#adadad] rounded-[10px]">
                <SelectValue placeholder="Select type" />
              </SelectTrigger>
              <SelectContent>
                <SelectItem value="monthly" onClick={() => setFieldsData({...fieldsData, employmentType: 'Monthly'})}>Monthly</SelectItem>
                <SelectItem value="weekly" onClick={() => setFieldsData({...fieldsData, employmentType: 'Weekly'})}>Weekly</SelectItem>
              </SelectContent>
            </Select>
          </div>
        </div>

        {/* Calendar */}
        <div>
          <Label className="text-sm text-[#717171]">Set Pay Day</Label>
          <Card className="mt-1 border-[3px] border-[#adadad] rounded-[15px]">
            <CardContent>
              <Calendar
                mode="single"
                selected={fieldsData.date}
                onSelect={(date) => setFieldsData({ ...fieldsData, date })}
                className="rounded-md w-full"
              />
            </CardContent>
          </Card>
        </div>


        {/* Document Upload */}
        <div className="space-y-2">
          <Label className="text-sm text-[#717171]">Contract</Label>
          <Button className="w-full bg-[#444444] text-white border-2 border-[#ffc067] rounded-[20px]">
            Attach Document File
          </Button>
        </div>

        {/* Submit Button */}
        <Button type="submit" className="w-full bg-[#ffc067] text-white rounded-[20px] h-12">
          Add Employee
        </Button>
      </form>

     {/* Bottom Navigation */}
     <div className="fixed bottom-0 left-0 right-0 bg-[#f6f7fb] p-4 shadow-md rounded-t-[40px]">
        <div className="flex justify-around max-w-md mx-auto">
          {[  
            { icon: Home, label: "Home", isActive: true },
            { icon: Inbox, label: "Inbox", isActive: false },
            { icon: History, label: "History", isActive: false },
            { icon: User, label: "Profile", isActive: false },
          ].map(({ icon: Icon, label, isActive }) => (
            <div key={label} className={`flex flex-col ${isActive ? 'text-blue-500' : ''} items-center`}>
              <Icon className="h-8 w-8" />
              <span className="text-sm mt-1">{label}</span>
            </div>
          ))}
        </div>
      </div>
      
    </div>
  </div>
);
}
