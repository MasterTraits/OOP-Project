import { ArrowLeft, Briefcase, User } from 'lucide-react';
import { Button } from "@/components/ui/button"
import { Input } from "@/components/ui/input"
import { Label } from "@/components/ui/label"
import { useState } from "react"

export default function RegistrationForm() {
  const [ein, setEin] = useState();

  return (
    <>
      <main className="w-[393px] min-h-screen flex flex-col items-center justify-center bg-white font-montserrat">
        <div className="w-full bg-gradient-to-br from-[#FFC067] to-[#699773] text-white">
          <header className="bg-[#f6f7fb] w-full h-[83px] rounded-b-[50px] shadow-md flex items-center">
            <ArrowLeft className="w-6 h-6 m-5 text-black" />
          </header>
          <h1 className="mt-[62px] ml-[37px] mb-1 text-[32px] font-bold leading-[39px] tracking-[-0.04em] text-left">
            Start your Journey
          </h1>
          <p className="text-[20px] leading-[24px] ml-[37px] mr-[33px] mb-[26px]">
            Gain access to easy and automated solutions
          </p>
        </div>

        <form className="w-full p-5 bg-gradient-to-b from-transparent via-[rgba(195,195,195,0.21872)] to-[#B4B4B4] rounded-[10px] shadow-md">
          <h2 className="text-[#444] my-5">Account Type</h2>
          <div className="flex justify-between mb-5">
            <Button variant="outline" className="w-[48%] bg-[#7FB68B] text-[#717171] border-[3px] border-[#AEAEAE] rounded-[20px]">
              <Briefcase className="w-5 h-5 mr-1" />
              Employer
            </Button>
            <Button variant="outline" className="w-[48%] bg-[#7FB68B] text-[#717171] border-[3px] border-[#AEAEAE] rounded-[20px]">
              <User className="w-5 h-5 mr-1" />
              Employee
            </Button>
          </div>

          <div className="mb-5">
            <Input type="text" placeholder="What is an EIN?" className="border-[3px] border-[#AEAEAE] rounded-[20px] text-lg mb-2" />
            <Label htmlFor="ein" className="text-[#699773] text-base">What is an EIN?</Label>
          </div>

          <h2 className="text-[#444] my-5">Your Personal Details</h2>
          <Input type="text" id="first-name" placeholder="Given Name" className="border-[3px] border-[#AEAEAE] rounded-[20px] text-lg mb-5" />
          <Input type="text" id="last-name" placeholder="Last Name" className="border-[3px] border-[#AEAEAE] rounded-[20px] text-lg mb-5" />

          <Label htmlFor="birthday" className="text-base font-medium leading-[19.5px] tracking-[-0.02em] text-left">Birthday</Label>
          <Input type="date" id="birthday" className="border-[3px] border-[#AEAEAE] rounded-[20px] text-lg mb-5" />

          <h2 className="text-[#444] my-5">Auth | Contact</h2>
          <Input type="email" placeholder="Email" className="border-[3px] border-[#AEAEAE] rounded-[20px] text-lg mb-5" />
          <Input type="tel" placeholder="63+ | Contact no." className="border-[3px] border-[#AEAEAE] rounded-[20px] text-lg mb-5" />
          <Input type="password" placeholder="Password" className="border-[3px] border-[#AEAEAE] rounded-[20px] text-lg mb-5" />
          <Input type="password" placeholder="Confirm Password" className="border-[3px] border-[#AEAEAE] rounded-[20px] text-lg mb-5" />

          <Button type="submit" className="w-full bg-[#ffc067] text-white font-bold rounded-[20px] text-lg">
            Sign-up
          </Button>
        </form>
      </main>
    </>
  );
};

