import { ArrowLeft, Briefcase, User } from "lucide-react";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { useState, useContext } from "react";
import { Link } from "react-router-dom";
import { UserContext } from "@/pages/UserContext";
import {
  AlertDialog,
  AlertDialogAction,
  AlertDialogCancel,
  AlertDialogContent,
  AlertDialogDescription,
  AlertDialogFooter,
  AlertDialogHeader,
  AlertDialogTitle,
  AlertDialogTrigger,
} from "@/components/ui/alert-dialog";
import instance from '@/lib/axiosConfig';

export default function RegistrationForm() {
  const [ein, setEin] = useState(true);
  const [fieldsData, setFieldsData] = useState({
    firstName: '',
    lastName: '',
    email: '',
    password: '',
    employer: ein,
    ein: '',
  });

  const handleSubmit = async (event) => {
    event.preventDefault();
    const formData = new FormData(event.target);
    const data = Object.fromEntries(formData.entries());
    data.first_name = fieldsData.firstName;
    data.last_name = fieldsData.lastName;
    data.email = fieldsData.email;
    data.password = fieldsData.password;
    data.employer = fieldsData.employer;
    data.ein = fieldsData.ein;

    try {
      const response = await instance.post('/auth/users', data, {
        headers: {
          'Content-Type': 'application/json',
        },
      });

      console.log('Employee added:', response.data);
    } catch (error) {
      console.error('Error adding employee:', error);
    }
    
    // if (fieldsData.employer == true) {
    //   setAuth(true);
    //   setEmployer(true);
    // } else {
    //   setAuth(true);
    // }
  };

  return (
    <>
      <main className="min-h-screen flex flex-col items-center justify-center bg-white font-montserrat">
        <div className="w-full bg-gradient-to-br from-[#FFC067] to-[#699773] text-white">
          <header className="bg-[#f6f7fb] w-full h-[83px] rounded-b-[50px] shadow-md flex items-center">
            <Link to="/">
              <ArrowLeft className="w-6 h-6 m-5 text-black" />
            </Link>
          </header>
          <h1 className="mt-[62px] ml-[37px] mb-1 text-[32px] font-bold leading-[39px] tracking-[-0.04em] text-left">
            Start your Journey
          </h1>
          <p className="text-[20px] leading-[24px] ml-[37px] mr-[33px] mb-[26px]">
            Gain access to easy and automated solutions
          </p>
        </div>

        <form
          onSubmit={handleSubmit}
          className="px-8 w-full p-5 bg-gradient-to-b from-transparent via-[rgba(215,215,215,0.22)] to-[#B4B4B4] rounded-[10px] shadow-md"
        >
          <h2 className="font-bold text-2xl text-[#444444] tracking-tight my-4">
            Account Type
          </h2>
          <div className="flex justify-between mb-3">
            <Button
              onClick={(e) => {
                setEin(true);
                e.preventDefault();
              }}
              variant="secondary"
              className={`w-[48%] ${
                ein ? "bg-[#7FB68B] text-neutral-950" : "text-[#717171]"
              }  border-[3px] border-[#AEAEAE] rounded-[20px]`}
            >
              <Briefcase className="w-5 h-5 mr-1" />
              Employer
            </Button>
            <Button
              onClick={(e) => {
                setEin(false);
                e.preventDefault();
              }}
              variant="secondary"
              className={`w-[48%] ${
                !ein ? "bg-[#7FB68B] text-black" : "text-[#717171]"
              }  border-[3px] border-[#AEAEAE] rounded-[20px]`}
            >
              <User className="w-5 h-5 mr-1" />
              Employee
            </Button>
          </div>

          {ein && (
            <div className="mb-7">
              <Input
                type="text"
                placeholder="Employer Identification Number"
                className="border-[3px] border-[#AEAEAE] rounded-[20px] text-md py-5 mb-2 pl-4"
                min="0"
                max="9"
                onChange={(e) => setFieldsData({ ...fieldsData, ein: e.target.value })}
              />
              <Label htmlFor="ein" className="text-[#699773] text-base">
                <a href="https://www.investopedia.com/terms/e/employer-identification-number.asp">
                  What is an EIN?
                </a>
              </Label>
            </div>
          )}

          <h2 className="font-bold text-2xl text-[#444444] tracking-tight my-4">
            Your Personal Details
          </h2>
          <Input
            type="text"
            id="first-name"
            placeholder="Given Name"
            className="border-[3px] border-[#AEAEAE] rounded-[20px] text-md mb-3 py-5 pl-4"
            onChange={(e) => setFieldsData({ ...fieldsData, firstName: e.target.value })}
          />
          <Input
            type="text"
            id="last-name"
            placeholder="Last Name"
            className="border-[3px] border-[#AEAEAE] rounded-[20px] text-md mb-2 py-5 pl-4"
            onChange={(e) => setFieldsData({ ...fieldsData, lastName: e.target.value })}
          />

          <Label
            htmlFor="birthday"
            className="leading-[19.5px] tracking-[-0.02em] text-left"
          >
            Birthday
          </Label>
          <Input
            type="date"
            id="birthday"
            className="border-[3px] border-[#AEAEAE] rounded-[20px] text-md mt-2 mb-7 py-5 pl-4"
            onChange={(e) => setFieldsData({ ...fieldsData, birthday: e.target.value })}
          />

          <h2 className="font-bold text-2xl text-[#444444] tracking-tight my-4">
            Auth | Contact
          </h2>
          <Input
            type="email"
            placeholder="Email"
            className="border-[3px] border-[#AEAEAE] rounded-[20px] text-md mb-3 py-5 pl-4"
            onChange={(e) => setFieldsData({ ...fieldsData, email: e.target.value })}
          />
          <Input
            type="tel"
            placeholder="63+ | Contact no."
            className="border-[3px] border-[#AEAEAE] rounded-[20px] text-md mb-3 py-5 pl-4"
            onChange={(e) => setFieldsData({ ...fieldsData, contact: e.target.value })}
          />
          <Input
            type="password"
            placeholder="Password"
            className="border-[3px] border-[#AEAEAE] rounded-[20px] text-md mb-3 py-5 pl-4"
          />
          <Input
            type="password"
            placeholder="Confirm Password"
            className="border-[3px] border-[#AEAEAE] rounded-[20px] text-md mb-7 py-5 pl-4"
            onChange={(e) => setFieldsData({ ...fieldsData, password: e.target.value })}
          />

          <AlertDialog className="w-full">
            <AlertDialogTrigger asChild>
              <Button
                type="submit"
                className="w-full bg-[#ffc067] text-white font-bold rounded-[20px] text-md mb-3"
              >
                Sign-up
              </Button>
            </AlertDialogTrigger>
            <AlertDialogContent>
              <AlertDialogHeader>
                <AlertDialogTitle>Data Privacy</AlertDialogTitle>
                <AlertDialogDescription>
                  The Republic Act 10173, officially known as the Data Privacy
                  Act of 2012 (DPA), is Philippine's data privacy law, aiming to
                  “to protect the fundamental human right of privacy, of
                  communication while ensuring free flow of information to
                  promote innovation and growth” while also ensuring “that
                  personal information in information and communications systems
                  in the government and in the private sector are secured and
                  protected. <br/><br/>This is an action solely dependent on your discretion
                </AlertDialogDescription>
              </AlertDialogHeader>
              <AlertDialogFooter>
                <AlertDialogCancel>Cancel</AlertDialogCancel>
                <AlertDialogAction onClick={()=> window.location.href = "/employer"}>Continue</AlertDialogAction>
              </AlertDialogFooter>
            </AlertDialogContent>
          </AlertDialog>
        </form>
      </main>
    </>
  );
}
