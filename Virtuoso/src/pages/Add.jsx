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
  ChevronLeft,
  ChevronRight,
  History,
  Home,
  Inbox,
  User,
} from "lucide-react";
import React from "react";

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

const toggleFields = [
  { id: "sss", label: "Social Security System *" },
  { id: "philhealth", label: "PhilHealth *" },
  { id: "pagibig", label: "Pag-IBIG *" },
];

export default function EmployerSide() {
  const [date, setDate] = React.useState(new Date());

  return (
    <div className="bg-[#f6f7fb] min-h-screen">
      <div className="max-w-md mx-auto bg-[#f6f7fb]">
        {/* Header */}
        <div className="p-6 shadow-md">
          <div className="flex justify-between items-center mb-4">
            <h1 className="text-[28px] font-bold text-[#444444] leading-tight">
              Add
              <br />
              Employee
            </h1>
            <Button
              variant="secondary"
              className="bg-[#717171] text-white rounded-full"
            >
              Cancel
            </Button>
          </div>

          <Button className="w-full bg-gradient-to-b from-[#ffc067] to-[#697973] text-white rounded-[20px] h-12">
            Create Group Chat
          </Button>
        </div>

        <div className="p-6 space-y-6">
          {/* Form Fields */}
          <div className="grid grid-cols-2 gap-4">
            {formFields.slice(0, 4).map((field, index) => (
              <div key={field.id} className={index === 4 ? "col-span-2" : ""}>
                <Label className="text-sm text-[#717171]">{field.label}</Label>
                <Input
                  placeholder={field.defaultValue}
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
              <CardContent className="p-2">
                <Calendar
                  mode="single"
                  selected={date}
                  onSelect={setDate}
                  className="rounded-md w-full"
                />
              </CardContent>
            </Card>
          </div>

          {/* Toggle Switches */}
          {toggleFields.map((field) => (
            <div key={field.id} className="space-y-2">
              <Label className="text-sm text-[#717171]">{field.label}</Label>
              <div className="flex gap-4">
                <div className="flex-1 flex items-center justify-center h-11 bg-[#c2c2c238] rounded-l-[10px] border-[3px] border-[#adadad]">
                  <span className="font-semibold text-[#444444]">NO</span>
                </div>
                <div className="flex-1 flex items-center justify-center h-11 bg-white rounded-r-[10px] border-[3px] border-[#adadad]">
                  <span className="font-semibold text-[#444444]">YES</span>
                </div>
              </div>
            </div>
          ))}

          {/* Document Upload */}
          <div className="space-y-2">
            <Label className="text-sm text-[#717171]">Contract</Label>
            <Button className="w-full bg-[#444444] text-white border-2 border-[#ffc067] rounded-[20px]">
              Attach Document File
            </Button>
          </div>

          {/* Submit Button */}
          <Button className="w-full bg-[#ffc067] text-white rounded-[20px] h-12">
            Add Employee
          </Button>
        </div>

        {/* Bottom Navigation */}
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
    </div>
  );
}
