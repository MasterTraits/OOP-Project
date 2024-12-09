import { Badge } from "@/components/ui/badge";
import { Button } from "@/components/ui/button";
import { Card, CardContent, CardHeader } from "@/components/ui/card";
import { Separator } from "@/components/ui/separator";
import {
  Home,
  Inbox,
  User,
} from "lucide-react";
import React from "react";
import Contract from '@/assets/Contract'
import Leave from '@/assets/Leave'
import Message from '@/assets/Message'
import PDFReader from "@/components/PDFReader";
import {
  Dialog,
  DialogContent,
  DialogDescription,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
} from "@/components/ui/dialog"
import { Link } from "react-router-dom";

const workDetails = [
  { label: "Hourly Rate:", hours: "1 hr", amount: "₱70" },
  { label: "Total Overtime:", hours: "12 hrs", amount: "₱840" },
  { label: "Total Tardiness:", hours: "2 hrs", amount: "- ₱760" },
  { label: "Leave:", hours: "0", amount: "₱0" },
  { label: "Absences:", hours: "3 d", amount: "- ₱840" },
];

const deductions = [
  { label: "SSS:", rate: "4.5%", amount: "₱324" },
  { label: "PhilHealth:", rate: "2.25%", amount: "₱162" },
  { label: "Pag-IBIG:", rate: "2%", amount: "₱100" },
  { label: "Income Tax", rate: "N/A", amount: "₱0" },
];

export default function EmployeeSide() {
  return (
    <div className="bg-[#f6f7fb] min-h-screen w-full mx-auto">
      <div className="p-4">
        {/* Header */}
        <header className="flex justify-between items-center p-4 bg-transparent mb-6">
          <div className="title-container">
            <h1 className="text-[28px] font-bold text-[#444] font-montserrat leading-none tracking-[-1.1px]">
              Hello, <br /> Name
            </h1>
          </div>
          <Button className="w-[78px] h-[34px] rounded-full bg-[#7FB68B] text-white text-center font-montserrat text-base font-bold">
            HELP
          </Button>
        </header>

        {/* Action Cards */}
        <div className="grid grid-cols-3 gap-4 mx-4 mb-6">
          <Dialog>
          <DialogTrigger className="flex flex-col items-center gap-2">
              <Card className="w-20 h-20 rounded-[40px] shadow-lg">
                <CardContent className="flex items-center justify-center h-full p-0">
                  <Contract className="h-8 w-8 text-[#444444]" />
                </CardContent>
              </Card>
              <span className="text-sm font-semibold text-[#444444] text-center leading-tight">
                Employer's Contract
              </span>
            </DialogTrigger>
            <DialogContent>
              <DialogHeader>
                <DialogTitle>Contract</DialogTitle>
                <DialogDescription>
                  <PDFReader />
                </DialogDescription>
              </DialogHeader> 
            </DialogContent>
          </Dialog>
            <Link 
              to="/employee/conversation"
              className="flex flex-col items-center gap-2"
            >
              <Card className="w-20 h-20 rounded-[40px] shadow-lg">
                <CardContent className="flex items-center justify-center h-full p-0">
                  <Leave className="h-8 w-8 text-[#444444]" />
                </CardContent>
              </Card>
              <span 
                className="text-sm font-semibold text-[#444444] text-center leading-tight">
                Message Employer
              </span>
            </Link>
            <Link 
              to="/employee/leave"
              className="flex flex-col items-center gap-2"
            >
              <Card className="w-20 h-20 rounded-[40px] shadow-lg">
                <CardContent className="flex items-center justify-center h-full p-0">
                  <Message className="h-8 w-8 text-[#444444]" />
                </CardContent>
              </Card>
              <span className="text-sm font-semibold text-[#444444] text-center leading-tight">
                Request Leave
              </span>
            </Link>
        </div>

        {/* Payslip Card */}
        <Card className="rounded-[20px] mx-2 mb-20 shadow-lg">
          <CardHeader className="flex-row gap-4 items-center">
            <div className="my-2 w-full">
              <h2 className="text-xl text-center font-bold text-[#444444]">
                Terminal de Biringan
              </h2>
              <p className="text-sm text-center text-[#444444]">
                123 Konsepto St., Biringan City, 6725
              </p>
            </div>
          </CardHeader>
          <CardContent className="space-y-6">
            <div className="flex gap-4">
              <Badge variant="secondary" className="rounded-md">
                Monthly Pay
              </Badge>
              <Badge variant="secondary" className="rounded-md">
                Part-time
              </Badge>
            </div>

            <div className="space-y-2">
              <div className="flex justify-between text-sm">
                <span className="font-bold text-[#444444]">Occupation:</span>
                <span className="text-[#444444]">Jeep Driver</span>
              </div>
              <div className="flex justify-between text-sm">
                <span className="font-bold text-[#444444]">Pay Date:</span>
                <span className="text-[#444444]">November 28, 2024</span>
              </div>
            </div>

            <Separator />

            {/* Work Details */}
            <div className="space-y-2">
              <div className="flex justify-between font-bold text-sm text-[#444444]">
                <span>Description</span>
                <div className="flex  gap-8">
                  <span>Rate</span>
                  <span>Total</span>
                </div>
              </div>
              {workDetails.map((item, index) => (
                <div
                  key={index}
                  className="flex justify-between text-sm text-[#444444]"
                >
                  <span className="font-semibold">{item.label}</span>
                  <div className="flex justify-evenly gap-8">
                    <span>{item.hours}</span>
                    <span>{item.amount}</span>
                  </div>
                </div>
              ))}
            </div>

            <Separator />

            {/* Work Summary */}
            <div className="space-y-2">
              <div className="flex justify-between text-sm text-[#444444]">
                <span className="font-semibold">Worked Days:</span>
                <div className="flex gap-8">
                  <span>23 d</span>
                  <span>92 hr</span>
                </div>
              </div>
              <div className="flex justify-between text-sm text-[#444444]">
                <span className="font-semibold">Total Hours:</span>
                <div className="flex gap-8">
                  <span>102 hr</span>
                  <span>₱7,200</span>
                </div>
              </div>
            </div>

            <Separator />

            {/* Deductions */}
            <div className="space-y-2">
              <div className="flex justify-between font-bold text-sm text-[#444444]">
                <span>Deductions</span>
                <div className="flex gap-8">
                  <span>Rate</span>
                  <span>Total</span>
                </div>
              </div>
              {deductions.map((item, index) => (
                <div
                  key={index}
                  className="flex justify-between text-sm text-[#444444]"
                >
                  <span className="font-semibold">{item.label}</span>
                  <div className="flex gap-8">
                    <span>{item.rate}</span>
                    <span>{item.amount}</span>
                  </div>
                </div>
              ))}
            </div>

            <Separator />

            {/* Net Pay */}
            <div className="flex justify-between text-sm text-[#444444]">
              <span className="font-semibold">Net Pay</span>
              <span>₱6,614</span>
            </div>

            <div className="text-center space-y-1 text-sm text-[#444444]">
              <p>This is a system generated payslip</p>
              <p>11/26/24</p>
            </div>
          </CardContent>
        </Card>
      </div>

      {/* Bottom Navigation */}
      <div className="fixed bottom-0 left-0 right-0 bg-[#f6f7fb] p-4 shadow-md rounded-t-[40px]">
        <div className="flex justify-around max-w-md mx-auto">
          {[
            { icon: Home, label: "Home", isActive: true },
            { icon: Inbox, label: "Inbox", isActive: false },
            { icon: User, label: "Profile", isActive: false },
          ].map(({ icon: Icon, label, isActive }) => (
            <div
              key={label}
              className={`flex flex-col ${
                isActive ? "text-blue-500" : ""
              } items-center`}
            >
              <Icon className="h-8 w-8" />
              <span className="text-sm mt-1">{label}</span>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}
