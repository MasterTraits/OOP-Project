import { Button } from "@/components/ui/button";
import { Card, CardContent } from "@/components/ui/card";
import React from "react";

export default function Landing() {
  return (
    <main className="min-h-screen bg-[#f0f4f3] flex items-center justify-center">
      <Card className="w-full h-screen bg-[#f0f4f3] border-none relative overflow-hidden">
        <CardContent className="p-0">
          {/* Decorative circles */}
          <div className="absolute w-64 h-[270px] -top-[110px] -left-[117px]">
            <div className="relative h-[270px]">
              <div className="absolute top-[70px] left-0 w-[200px] h-[200px] rounded-full bg-[#ffc06780]" />
              <div className="absolute top-0 left-[100px] w-[200px] h-[200px] rounded-full bg-[#7fb68b80]" />
            </div>
          </div>

          {/* Logo */}
          <div className="flex flex-col items-center">
            <img
              src="/KITAKIT.png"
              alt="Virtuoso Logo"
              className="h-1/2 w-1/2 mt-[259px] mb-7"
            />
          </div>

          {/* Content */}
          <div className="flex flex-col items-center px-6">
            <div className="text-md font-semibold text-[#ffc067] text-center max-w-[203px] leading-[22px] mb-24">
              Asenso ng Negosyo, Sagot Namin.
            </div>
          </div>

          {/* Buttons */}
          <div className="absolute bottom-14 left-0 right-0 px-[50px] space-y-4">
            <Button
              variant="outline"
              onClick={() => window.location.href = "/login"}
              className="w-full h-14 text-xl font-bold tracking-tight border-[5px] border-[#ffc067] text-[#ffc067] rounded-[20px]"
            >
              Sign-in
            </Button>
            <Button 
              onClick={() => window.location.href = "/register"}
              className="w-full h-14 text-xl font-bold tracking-tight bg-[#ffc067] text-white hover:bg-[#ffc067]/90 rounded-[20px]">
              Register
            </Button>
          </div>
        </CardContent>
      </Card>
    </main>
  );
}