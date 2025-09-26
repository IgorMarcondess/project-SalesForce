'use client'
import { useState } from "react";
import LogoSalesForce from "./../../../public/Logo_SalesForce.svg";
import Link from "next/link";



export default function Header() {
    const [isMenuOpen, setIsMenuOpen] = useState(true);

    const toggleMenu = () => {
        setIsMenuOpen(!isMenuOpen);
    };

    return (
        <header>
            <div className="w-full h-28 bg-azulEscuro-100 flex p-2 items-center justify-between md:pl-16 md:pr-16">
                <Link href={"./"}>
                    <img className="w-28" src={LogoSalesForce.src} />
                </Link>
                <div className="flex justify-end gap-4 items-center text-center">
                    <Link href={"./trailfinder"}>
                        <h1 className="flex text-slate-50 font-black text-xs hover:bg-slate-50 hover:text-azulEscuro-100 hover:p-1 hover:rounded-lg md:flex md:font-black md:text-2xl">Trail Finder</h1>
                    </Link>
                    <Link href={"https://trailhead.salesforce.com/trailblazers"} target="_blank">
                        <h1 className="flex text-slate-50 font-black text-xs hover:bg-slate-50 hover:text-azulEscuro-100 hover:p-1 hover:rounded-lg md:flex md:font-black md:text-2xl">Trail Blazers</h1>
                    </Link>
                <div className="relative inline-block text-left">
                        <div>
                            <button
                                type="button"
                                className="inline-flex w-full justify-center gap-x-1.5 rounded-md bg-white px-3 py-2 text-sm font-semibold text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 hover:bg-gray-50"
                                id="menu-button"
                                onClick={toggleMenu}>Menu
                            </button>
                        </div>
                        {!isMenuOpen && (
                            <div
                                className="absolute right-0 z-10 mt-2 w-56 origin-top-right rounded-md bg-white shadow-lg ring-1 ring-black ring-opacity-5 focus:outline-none"
                                role="menu"
                                aria-orientation="vertical"
                                aria-labelledby="menu-button"
                            >
                                <div className="py-1" role="none">
                                    <a href={"./trailfinder"} className="block px-4 py-2 text-sm text-gray-700" role="menuitem" id="menu-item-0">Trail Finder</a>
                                    <a href={"./loginColaborador"} className="block px-4 py-2 text-sm text-gray-700" role="menuitem" id="menu-item-1">Colaborador</a>
                                </div>
                            </div>
                        )}
                    </div>
                </div>
            </div>
        </header>
    );
}