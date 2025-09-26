'use client'
import { useEffect } from "react";
import imagem1 from "../../../../public/images/imagem1.png";

// Extender o tipo de `window` para incluir VLibras
declare global {
  interface Window {
    VLibras: any;
  }
}

export default function PaginaInicial1() {
  useEffect(() => {
    const script = document.createElement('script');
    script.src = 'https://vlibras.gov.br/app/vlibras-plugin.js';
    script.async = true;
    document.body.appendChild(script);

    script.onload = () => {
      if (window.VLibras) {
        new window.VLibras.Widget('https://vlibras.gov.br/app');
      }
    };
  }, []);

  return (
    <>
      <main>
        <div className="bg-azulEscuro-100 w-full h-3/4 flex flex-col items-center text-xl md:bg-azulEscuro-100 md:h-96 md:flex md:flex-row md:items-center">
          <h1 className="font-titulo w-6/12 text-slate-50 md:font-titulo md:w-2/4 md:ml-16 md:mx-11 md:mr-16 md:text-xl">
          A Salesforce é uma empresa global de tecnologia especializada em software de CRM (Gerenciamento de relacionamento com o cliente), que visa conectar empresas e clientes de 
          maneira eficaz e estratégica. Sua plataforma integrada proporciona a todos os departamentos, incluindo vendas, marketing, atendimento e operações, uma visão única e 
          em tempo real de cada cliente. Isso permite que as equipes trabalhem de forma colaborativa e alinhada,
           promovendo uma comunicação personalizada e ágil, o que resulta em uma experiência de atendimento coesa, eficiente e centrada nas necessidades do cliente.
          </h1>
          <img className="w-80 h-80 md:ml-28" src={imagem1.src} alt="Imagem ilustrativa de uma mulher sorrindo"/>
        </div>
      </main>
    </>
  );
}
