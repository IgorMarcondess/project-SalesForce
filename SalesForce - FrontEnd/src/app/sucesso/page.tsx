import imagens from "./navbar-sucesso.json";
import sucesso from "./../../../public/complete.png";
import Link from 'next/link';

interface dados {
  id: number;
  src: string;
  text: string;
  href: string;
}

export default function TrailFinder() {
  return (
    <section className="flex justify-center items-center my-20 bg-[#cce3de] p-6 rounded-lg w-full max-w-5xl mx-auto">
      <div className="flex flex-col items-center text-center justify-center">
        <div className="flex justify-center items-center mb-4">
          <h2 className="text-lg md:text-2xl font-bold text-gray-700">Informações enviadas com sucesso</h2>
          <img className="w-12 h-12 ml-2" src={sucesso.src} alt="Sucesso" />
        </div>
        <h4 className="text-gray-600 text-sm md:text-base mb-2">Retornaremos com a resposta em breve</h4>
        <h3 className="text-gray-600 text-sm md:text-base mb-6">Enquanto aguarda o retorno, confira as opções recomendadas para suas características:</h3>

        <div className="flex justify-center items-center gap-6 flex-wrap">
          {imagens.map((item2: dados) => (
            <div key={item2.id} className="flex flex-col items-center bg-[#032D60] p-4 rounded-lg shadow-lg transition-transform transform hover:scale-105 w-48">
              <a href={item2.href} target="_blank" className="flex justify-center items-center w-full mb-4">
                <img className="w-full max-w-xs object-cover" src={item2.src} alt={item2.text} />
              </a>
              <ul className="list-none text-center">
                <li className="text-white font-semibold text-base">{item2.text}</li>
              </ul>
            </div>
          ))}
        </div>

        {/* Contêiner de centralização para o botão */}
        <div className="flex justify-center w-full mt-8">
          <Link href={"./PaginaInicial"}>
            <button className="px-6 py-2 bg-blue-500 text-white font-semibold rounded-lg hover:bg-blue-600 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:ring-offset-2">
              Voltar à Página Inicial
            </button>
          </Link>
        </div>
      </div>
    </section>
  );
}
