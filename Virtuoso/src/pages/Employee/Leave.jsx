import { Badge } from "@/components/ui/badge";
import { Card, CardContent, CardHeader } from "@/components/ui/card";
import { Input } from "@/components/ui/input";
import { Textarea } from "@/components/ui/textarea";
import React from "react";
import { Link } from "react-router-dom";
import {
  Home,
  Inbox,
  User,
} from "lucide-react";

const Leave = () => {
  return (
    <div className="flex justify-center w-full bg-[#f6f7fb] min-h-screen">
      <div className="w-[393px]">
        <Card className="rounded-none shadow-md bg-[#f6f7fb]">
          <CardHeader className="space-y-0 pb-2">
            <div className="flex justify-between items-center mb-4">
            <h1 className="text-[28px] font-bold text-[#444] font-montserrat leading-none tracking-[-1.1px]">
              Employee <br /> Concern
            </h1>
              <Link
                to="/employee"
                variant="secondary"
                className="py-1 px-4 bg-neutral-400 font-bold text-white rounded-full hover:bg-[#699773]"
              >
                Cancel
              </Link>
            </div>
          </CardHeader>
        </Card>
          <CardContent className='border border-neutral-300 flex items-center gap-4 w-full py-4'>
              <Badge
                variant="secondary"
                className="bg-[#d9d9d9] text-black rounded-full px-4 py-2 text-lg font-medium"
              >
                Subject:
              </Badge>
              <Input 
                placeholder="Your subject"
                className='text-xl font-semibold text-[#444444] outline-none border-none bg-transparent w-full'
              />
          </CardContent>
          <Textarea
              placeholder="Write here"
              className="px-6 pt-4 w-full h-full text-black font-medium resize-none bg-transparent border-none shadow-none focus-visible:ring-0"
            />
            {/* Bottom Navigation */}
      </div>
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
};

export default Leave;