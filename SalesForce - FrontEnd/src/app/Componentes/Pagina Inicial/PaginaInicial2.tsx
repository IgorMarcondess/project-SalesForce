import Parceria1 from "../../../../public/Parcerias/gympass.png"
import Parceria2 from "../../../../public/Parcerias/sumup.png"
import Parceria3 from "../../../../public/Parcerias/tigre.png"
import Parceria4 from "../../../../public/Parcerias/vipal.png"

export default function PaginaInicial2(){
    return(
        <>
            <main className="mb-8 shadow-xl">
                <div className="bg-azulEscuro-100 w-full h-full flex flex-col justify-center items-center p-4 md:bg-azulEscuro-100 md:w-full h-60 md:flex md:flex-row md:justify-left md:items-center md:p-4 md:justify-around">
                    <h1 className="font-titulo text-2xl w-96 text-center text-slate-50 mb-6 mt-20 mt-[-.1px] md:font-titulo md:text-xl md:w-48 md:text-center md:text-slate-50 ">Empresas que utilizam nosso software</h1>
                    <div className="mini:hidden sm:hidden md:w-12 md:h-12 md:rounded-full md:bg-[rgb(20,20,20)] md:border-none md:font-semibold md:flex md:items-center md:justify-center md:rotate-[-90deg]">
                    <svg className="w-3 transition-all duration-300" viewBox="0 0 384 512">
                        <path
                        d="M214.6 41.4c-12.5-12.5-32.8-12.5-45.3 0l-160 160c-12.5 12.5-12.5 32.8 0 45.3s32.8 12.5 45.3 0L160 141.2V448c0 17.7 14.3 32 32 32s32-14.3 32-32V141.2L329.4 246.6c12.5 12.5 32.8 12.5 45.3 0s12.5-32.8 0-45.3l-160-160z"
                        fill="white"
                        ></path>
                    </svg>
                    </div>   
                    <img src={Parceria1.src} className="md:w-[18vw] md:grayscale md:hover:grayscale-0 md:duration-1000" alt="Imagem da logo parceiro"/>
                    <img src={Parceria2.src} className="md:w-[18vw] md:grayscale md:hover:grayscale-0 md:duration-1000" alt="Imagem da logo parceiro"/>
                    <img src={Parceria3.src} className="md:w-[18vw] md:grayscale md:hover:grayscale-0 md:duration-1000" alt="Imagem da logo parceiro"/>
                    <img src={Parceria4.src} className="md:w-[18vw] md:grayscale md:hover:grayscale-0 md:duration-1000" alt="Imagem da logo parceiro"/>
                </div>
            </main>
        </>
    )
}