'use client';

import { useState, useEffect } from 'react';
import { FaPlus, FaArrowRight } from 'react-icons/fa';
import { IoReorderThreeOutline } from "react-icons/io5";
import { BsPaperclip } from "react-icons/bs";
import { BsSendArrowDown } from "react-icons/bs";
import Mic from "@/assets/Mic";
import { Link } from 'react-router-dom';

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


export default function ChatInterface() {
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
          {/* Header */}
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
                to="/employee"
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