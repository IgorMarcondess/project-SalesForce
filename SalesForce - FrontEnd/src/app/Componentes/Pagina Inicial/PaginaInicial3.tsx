'use client'
import React, { useState } from "react";
import dados1 from "./imgs-paginaInicial1.json";
import imagem from "../../../../public/personagem.jpeg";
import Link from "next/link";

interface Dados {
  id: number;
  src: string;
  text: string;
  external: string;
  description: string;
}

export default function PaginaInicial3() {
  const [selectedItem, setSelectedItem] = useState<Dados | null>(null);

  const openModal = (item: Dados) => {
    setSelectedItem(item);
  };

  const closeModal = () => {
    setSelectedItem(null);
  };

  return (
    <>
          <section className="p-6 bg-white w-5/4 h-auto bg-azulEscuro-100">
        <h1 className="text-4xl font-bold text-center mb-6">Trail Finder</h1>
        <div className="flex flex-col md:flex-row items-center md:justify-center">
          <div className="flex flex-col items-center md:items-start mb-6 md:mb-0">
            <div className="max-w-lg text-center md:text-left mb-4">
              <h2 className="text-lg mb-4">
              Conheça o <strong>Trail Finder</strong> Aqui, você poderá responder a algumas perguntas simples sobre sua empresa – como seu tamanho e ramo de atuação. 
              Com essas respostas, vamos recomendar as ferramentas e serviços 
              mais adequados para as suas necessidades. Além disso, oferecemos uma solução personalizada para os desafios que você nos apresentar. 
              Vamos começar essa jornada juntos?
              </h2>
              <h3 className="text-lg font-semibold">Faça o teste agora mesmo!</h3>
            </div>
            <div>
              <Link href="./trailfinder">
                <button className="px-6 py-2 bg-blue-500 text-white rounded-lg font-bold opacity-90 hover:bg-blue-600 hover:opacity-100">
                  Questionário
                </button>
              </Link>
            </div>
          </div>
          <a className="flex-shrink-0">
            <img src={imagem.src} className="w-52 h-auto" alt="Personagem Trail Finder" />
          </a>
        </div>
      </section>

      <div className="text-center mb-8">
        <h1 className="text-3xl font-bold">Personagens</h1>
        <h3 className="text-xl">e seus significados</h3>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-8 mb-8">
        {dados1.map((item: Dados) => (
          <div key={item.id} className="flex flex-col items-center">
            <button onClick={() => openModal(item)} className="block">
              <img
                className="w-[40vw] h-auto object-cover md:w-[20vw] md:h-auto md:object-cover"
                src={item.src}
                alt={item.text}
              />
            </button>
            <ul className="mt-4">
              <li className="text-lg text-center">
                <button onClick={() => openModal(item)} className="text-blue-500 hover:underline">
                  {item.text}
                </button>
              </li>
            </ul>
          </div>
        ))}
      </div>
      {/* Modal */}
      {selectedItem && (
        <>
          <div
            className="fixed top-0 left-0 w-full h-full bg-black bg-opacity-60 z-50"
            onClick={closeModal}
          ></div>
          <div className="fixed top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2 bg-white p-8 rounded-lg z-50 w-96 max-w-full">

            <div className="modal-header flex justify-between items-center">
              <h2 className="text-2xl font-bold">{selectedItem.text}</h2>
              <button onClick={closeModal} className="text-red-500 font-bold">Fechar</button>
            </div>

            <div className="modal-body mt-4">
              <p>{selectedItem.description}</p>
              <a
                href={selectedItem.external}
                target="_blank"
                rel="noopener noreferrer"
                className="text-blue-500 hover:underline mt-4 block"
              >
                Link externo
              </a>
            </div>
          </div>
        </>
      )}
    </>
  );
}
