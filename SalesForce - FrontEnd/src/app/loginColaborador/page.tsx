'use client'
import { useState } from "react"
import personagens from "./../../../public/personagensBexiga.jpeg"
import { useRouter } from "next/navigation"  

export default function LoginColaborador() {
    const router = useRouter()

    const envioForm = (event) => {  
        event.preventDefault();
        router.push("./Colaborador"); 
    }

    return (
        <>
            <section className="p-4 bg-gray-100 flex flex-col lg:flex-row justify-center items-center min-h-screen">
                <form className="bg-white p-6 rounded-lg shadow-md w-full max-w-md sm:max-w-lg h-min-[30vh] lg:w-2/5 lg:h-[50vh] xl:w-[40vw] xl:h-[30rem] mb-8 lg:mb-0 lg:mr-8 2xl:h-[50vh]" onSubmit={envioForm}>
                    <div className="flex flex-col items-start mb-4">
                        <svg className="w-8 h-8 mr-2 mt-8 text-blue-500 2xl:w-12 2xl:h-12" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor">
                            <path fill="none" d="M0 0h24v24H0z"></path>
                            <path d="M4 15h2v5h12V4H6v5H4V3a1 1 0 0 1 1-1h14a1 1 0 0 1 1 1v18a1 1 0 0 1-1-1v-6zm6-4V8l5 4-5 4v-3H2v-2h8z"></path>
                        </svg>
                        <h1 className="text-2xl font-medium mb-4 2xl:text-4xl ">Login</h1>
                        <p className="text-xl 2xl:text-3xl">Colaborador Sales Force</p>
                    </div>
                    <div className="mb-6">
                        <label className="block text-gray-700 mb-2 2xl:text-xl" htmlFor="email">Informe seu e-mail:</label>
                        <input className="w-full px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500" name="email" type="email" placeholder="E-mail" required />
                    </div>
                    <div className="mb-4">
                        <label className="block text-gray-700 mb-2 2xl:text-xl" htmlFor="password">Informe sua senha:</label>
                        <input className="w-full px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500" name="password" type="password" placeholder="Senha" required />
                    </div>
                    <div className="mt-6 flex justify-center">
                        <button className="w-full lg:w-52 bg-blue-500 text-white py-2 px-4 rounded-lg hover:bg-blue-600 focus:outline-none focus:ring-2 focus:ring-blue-500" type="submit">ENVIE</button>
                    </div>
                </form>
                
                <div className="flex justify-center">
                    <img className="w-full h-auto max-w-md md:max-w-lg lg:max-w-full lg:h-80 rounded-lg xl:w-[50vw] 2xl:h-[45vh]" src={personagens.src} alt="Personagens com Bexiga" />
                </div>
            </section>
        </>
    )
}
