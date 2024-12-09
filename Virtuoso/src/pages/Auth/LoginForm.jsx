import { Button } from "@/components/ui/button";
import { Card, CardContent } from "@/components/ui/card";
import { Checkbox } from "@/components/ui/checkbox";
import { Input } from "@/components/ui/input";
import { ArrowLeft } from "lucide-react";
import React from "react";

export default function SignIn() {
  return (
    <div className="bg-[#f6f7fb] overflow-y-hidden">
      <div className="relative w-full overflow-hidden">
        {/* Gradient Background */}
        <div className="absolute inset-0 h-[473px] bg-gradient-to-tr from-[#699773] to-[#FFC067]" />

        {/* Bottom Gradient */}
        <div className="absolute inset-x-0 top-[373px] bg-gradient-to-b from-transparent via-[rgba(194,194,194,0.22)] to-[#b3b3b3]" />

        {/* Top Navigation Bar */}
        <Card className="relative flex items-center pl-6 w-full h-[83px] rounded-b-[50px] shadow-md bg-[#f6f7fb] border-none">
          <ArrowLeft className="h-6 w-6" />
        </Card>

        {/* Welcome Text */}
        <div className="relative z-10 px-9 pt-20">
          <h1 className="font-bold text-[32px] text-white tracking-tight">
            Welcome Back!
          </h1>
          <p className="font-medium text-xl text-white tracking-tight mt-2">
            We're glad seeing you again.
          </p>
        </div>

        {/* Sign In Form */}
        <div className="relative z-10 px-8 pt-64 overflow-y-hidden">
          <h2 className="font-bold text-2xl text-[#444444] tracking-tight mb-6">
            Access the latest
          </h2>

          <div className="space-y-4">
            <Input
              className="h-[50px] rounded-[20px] border-[3px] border-[#adadad] bg-transparent px-5"
              placeholder="Email or Contact no."
            />

            <Input
              type="password"
              className="h-[50px] rounded-[20px] border-[3px] border-[#adadad] bg-transparent px-5"
              placeholder="Password"
            />

            <div className="flex items-center space-x-3">
              <Checkbox
                id="remember"
                className="h-5 w-5 rounded-[5px] border-none bg-[#adadad]"
              />
              <label
                htmlFor="remember"
                className="font-semibold text-lg text-[#ffc067] tracking-tight cursor-pointer"
              >
                Forgot Password
              </label>
            </div>

            <Button className="w-full h-14 bg-[#ffc067] hover:bg-[#ffc067]/90 rounded-[20px] font-bold text-xl tracking-tight">
              Sign-in
            </Button>
          </div>
        </div>
      </div>
    </div>
  );
}
