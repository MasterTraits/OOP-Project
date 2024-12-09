import { Button } from "@/components/ui/button";
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
import {
  History,
  Home,
  Inbox,
  User,
} from "lucide-react";
import React from "react";
import { Link } from "react-router-dom";

const formFields = [
  {
    id: "givenName",
    label: "Given Name *",
    defaultValue: "Juan Dela",
    required: true,
  },
  {
    id: "lastName",
    label: "Last Name *",
    defaultValue: "Cruz",
    required: true,
  },
  { id: "userId", label: "User ID *", defaultValue: "XXXX-XX", required: true },
  {
    id: "contact",
    label: "Contact *",
    defaultValue: "+63 000 000 0000",
    required: true,
  },
  {
    id: "email",
    label: "Email (Optional)",
    defaultValue: "sample@gmail.com",
    required: false,
  },
];


export default function EmployerSide() {
  const [date, setDate] = React.useState(new Date());

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

          {/* <Button className="mt-7 w-full h-[46px] rounded-[20px] bg-gradient-to-br from-[#FFC067] to-[#699773] shadow-md text-white text-center font-montserrat text-base font-semibold tracking-[-0.64px]">
            Create a Group Chat
          </Button> */}
        </div>

        <form className="p-6 space-y-4">
          {/* Form Fields */}
          <div className="grid grid-cols-2 gap-2">
            {formFields.slice(0, 4).map((field, index) => (
              <div key={field.id} className={index === 4 ? "col-span-2" : ""}>
                <Label className="text-sm text-[#717171]">{field.label}</Label>
                <Input
                  placeholder={field.defaultValue}
                  required={field.required}
                  className="mt-1 border-[3px] border-[#adadad] rounded-[10px]"
                />
              </div>
            ))}
          </div>

          <div className="col-span-2">
            <Label className="text-sm text-[#717171]">
              {formFields[4].label}
            </Label>
            <Input
              defaultValue={formFields[4].defaultValue}
              className="mt-1 border-[3px] border-[#adadad] rounded-[10px]"
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
                  <SelectItem value="part-time">Part-time</SelectItem>
                  <SelectItem value="full-time">Full-time</SelectItem>
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
                  <SelectItem value="monthly">Monthly</SelectItem>
                  <SelectItem value="weekly">Weekly</SelectItem>
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
                  selected={date}
                  onSelect={setDate}
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
            Update Employee
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
