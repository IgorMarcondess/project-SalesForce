'use client'
import Instagram from "./../../../public/Social Medias/instagram.svg";
import Facebook from "./../../../public/Social Medias/facebook.svg";
import SalesForce from "./../../../public/Logo_SalesForce.svg"
import AMR from "./../../../public/AMR.png"
import Link from "next/link";

export default function Footer(){
    return(
    <>
    <footer>
        <div className="w-full h-auto bg-azulEscuro-100 flex flex-col p-2 items-center justify-between gap-4 md:pl-16 md:pr-16 md:flex-row ">
            <div className="flex mini:flex-col gap-1 sm:flex-row md:flex md:flex-col md:gap-2">
                <Link href={"https://www.instagram.com/salesforcebrasil/"}>
                <button className="inline-flex w-26 justify-center items-center gap-x-1.5 rounded-md bg-white px-3 py-2 text-sm font-semibold text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 hover:bg-gray-50">
                        <img className="w-6" src={Instagram.src}/><h1>INSTAGRAM</h1>
                </button>
                </Link>
                <Link href={"https://web.facebook.com/SalesforceBrasil"}>
                    <button className="inline-flex w-26 justify-center items-center gap-x-1.5 rounded-md bg-white px-3 py-2 text-sm font-semibold text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 hover:bg-gray-50">
                            <img className="w-6" src={Facebook.src}/><h1>FACEBOOK</h1>
                    </button>
                </Link>
            </div>

            <div className="hidden sm:hidden md:flex md:flex-col">
                <h1 className="md:text-white md:font-bold md:flex md:justify-center">Mapa de navegação</h1>
                <div className="flex md:flex md:gap-3 md:justify-center md:text-white">
                    <div>
                        <Link href={"./trailfinder"}>
                            <p>Trail Finder</p>
                        </Link>
                    </div>
                    <div>
                        <Link href={"./loginColaborador"}>
                            <p>Colaborador</p>
                        </Link>
                    </div>
                    <div>
                        <Link href={"./"}>
                            <p>Página Inicial</p>
                        </Link>
                    </div>
                </div>
            </div>

            <section>
                <div className="mini:w-vw50 h-auto bg-slate-50 flex flex-col items-center justify-center gap-2 sm:bg-slate-50 sm:w-vw50 md:w-3/5 md:h-32 md:bg-slate-50 md:gap-0 md">
                    <img className="w-40 my-1 md:w-20" src={SalesForce.src}/>
                    <div className="w-12 bg-azulEscuro-100 h-0.5"></div>
                    <img className="w-40 md:w-32" src={AMR.src}/>
                </div>
            </section>

        </div>
    </footer>
    </>
    )
}