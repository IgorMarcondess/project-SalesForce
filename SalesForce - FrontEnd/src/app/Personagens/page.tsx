'use client'
import Einstein from "../../../public/Personagens_PI/einstein.png";
import Appy from "../../../public/Personagens_PI/appy.png"
import Astro from "../../../public/Personagens_PI/astro.png"
import Cloudy from "../../../public/Personagens_PI/cloudy.png"
import Codey from "../../../public/Personagens_PI/codey.png"
import Hootie from "../../../public/Personagens_PI/hootie.png"
import Max from "../../../public/Personagens_PI/max.png"
import Ruth from "../../../public/Personagens_PI/ruth.png"
import Blaze from "../../../public/Personagens_PI/blaze.png"
import Koa from "../../../public/Personagens_PI/koa.png"

export default function personagens(){
    return(
    <>
       <nav className="bg-white">
            <section className="space-y-8 flex flex-col justify-center items-center mt-8 mb-8">
                <div className="flex flex-col md:flex-row items-center space-y-4 md:space-y-0 md:space-x-8">
                <a className="flex-shrink-0">
                    <img src={Einstein.src} className="w-40 h-auto object-cover rounded-full" alt="Einstein" />
                </a>
                <div className="max-w-xl">
                    <h1 className="text-2xl font-bold text-gray-900">Einstein</h1>
                    <h2 className="text-xl font-semibold text-gray-700"><b>O gênio de todos</b></h2>
                    <p className="text-gray-600 mt-2">
                    Einstein é o cientista de dados da Salesforce. Nasceu em 2016 e foi criado com base em um dos maiores gênios da história mundial. Além de ser rápido, ele é o cérebro por trás da inteligência artificial da empresa. Tem um produto que leva seu nome: uma plataforma unificada que identifica oportunidades de vendas, prevê resultados e faz recomendações inteligentes.
                    </p>
                    <p className="text-gray-600 mt-2">
                    É um eterno solucionador de problemas e ajuda você a aprender mais sobre seus clientes. Brilhante e altruista, Einstein está sempre pronto para ajudá-lo a se tornar mais experiente e inovador. Outros produtos que ele oferece são o Einstein Sales Cloud e Einstein Analytics.
                    </p>
                </div>
                </div>

                <div className="flex flex-col md:flex-row items-center space-y-4 md:space-y-0 md:space-x-8">
                <a className="flex-shrink-0">
                    <img src={Appy.src} className="w-40 h-auto object-cover rounded-full" alt="Appy" />
                </a>
                <div className="max-w-xl">
                    <h1 className="text-2xl font-bold text-gray-900">APPY</h1>
                    <h2 className="text-xl font-semibold text-gray-700"><b>Sua guia no ecossistema de parceiros</b></h2>
                    <p className="text-gray-600 mt-2">
                    A Appy representa ISVs, parceiros e AppExchange. Ela surgiu em 2017, sabe muito sobre todas as coisas da Salesforce e é a mascote certa para ajudar na navegação do ecossistema do AppExchange para resolver desafios de negócios.
                    </p>
                    <p className="text-gray-600 mt-2">
                    Ela também é considerada um conector, pois se não souber a resposta, ela usa sua extensa rede para conectar as pessoas certas e resolver seus problemas. A Appy acredita nas pessoas e inspira empreendedores do mundo todo a viver os sonhos e transformar os negócios.
                    </p>
                </div>
                </div>

                <div className="flex flex-col md:flex-row items-center space-y-4 md:space-y-0 md:space-x-8">
                <a className="flex-shrink-0">
                    <img src={Astro.src} className="w-40 h-auto object-cover rounded-full" alt="Astro" />
                </a>
                <div className="max-w-xl">
                    <h1 className="text-2xl font-bold text-gray-900">ASTRO</h1>
                    <h2 className="text-xl font-semibold text-gray-700"><b>O guia da Salesforce</b></h2>
                    <p className="text-gray-600 mt-2">
                    Astro é o seu guia amigável para tudo na Salesforce e ajuda você a se tornar o melhor em tudo o que deseja fazer. Nasceu em 2014 e representa comunidade e inclusão, incentivando a todos a atingirem seus objetivos sem medo de experimentar coisas novas.
                    </p>
                    <p className="text-gray-600 mt-2">
                    É curioso e adora viajar, aprender e fazer novas amizades. Sua identidade de gênero é não-binária para representar os valores de diversidade e inclusão de nossa empresa.
                    </p>
                </div>
                </div>

                <div className="flex flex-col md:flex-row items-center space-y-4 md:space-y-0 md:space-x-8">
                <a className="flex-shrink-0">
                    <img src={Cloudy.src} className="w-40 h-auto object-cover rounded-full" alt="Cloudy" />
                </a>
                <div className="max-w-xl">
                    <h1 className="text-2xl font-bold text-gray-900">CLOUDY</h1>
                    <h2 className="text-xl font-semibold text-gray-700"><b>Mantém todos unidos e no caminho certo</b></h2>
                    <p className="text-gray-600 mt-2">
                    Inteligente e cheia de experiência em tecnologia, Cloudy nasceu em 2015 e é responsável por criar aplicativos inovadores na nuvem. Fiel ao seu nome, ela está sempre no centro da ação e tem um imenso conhecimento de tudo relacionado ao armazenamento de dados na nuvem.
                    </p>
                    <p className="text-gray-600 mt-2">
                    Cloudy representa os administradores da Salesforce, traz à tona o melhor de todos e incentiva você a explorar seu próprio potencial ilimitado.
                    </p>
                </div>
                </div>

                <div className="flex flex-col md:flex-row items-center space-y-4 md:space-y-0 md:space-x-8">
                <a className="flex-shrink-0">
                    <img src={Codey.src} className="w-40 h-auto object-cover rounded-full" alt="Codey" />
                </a>
                <div className="max-w-xl">
                    <h1 className="text-2xl font-bold text-gray-900">CODEY</h1>
                    <h2 className="text-xl font-semibold text-gray-700"><b>O urso que inspira desenvolvedores e criadores pelo mundo</b></h2>
                    <p className="text-gray-600 mt-2">
                    É quase impossível não notar Codey: um urso lidando com projetos e sujando as patas, seja codificando e desenvolvendo um aplicativo ou servindo café com leite como um Bearista.
                    </p>
                    <p className="text-gray-600 mt-2">
                    Nascido em 2015, ele representa os desenvolvedores da Salesforce e inspira você a construir qualquer coisa usando cliques ou códigos. Embora pareça grande e destemido, Codey é muito carismático e adora dar abraços de urso. Ele é o mascote que vai trazer diversão aos seus projetos criativos.
                    </p>
                </div>
                </div>

                <div className="flex flex-col md:flex-row items-center space-y-4 md:space-y-0 md:space-x-8">
                <a className="flex-shrink-0">
                    <img src={Hootie.src} className="w-40 h-auto object-cover rounded-full" alt="Hootie" />
                </a>
                <div className="max-w-xl">
                    <h1 className="text-2xl font-bold text-gray-900">HOOTIE</h1>
                    <h2 className="text-xl font-semibold text-gray-700"><b>O sábio em busca do sucesso e novos aprendizados</b></h2>
                    <p className="text-gray-600 mt-2">
                    Hootie é uma coruja que representa Trailhead Academy. Ele ajuda você a conquistar novas habilidades, ganhar credenciais e buscar sucesso na sua carreira da melhor forma.
                    </p>
                    <p className="text-gray-600 mt-2">
                    É muito sábio, está sempre em busca de novos aprendizados e acredita que, com preparação e estudo, sua carreira pode alcançar novos patamares. Voe como Hootie e consiga o emprego dos seus sonhos!
                    </p>
                </div>
                </div>

                <div className="flex flex-col md:flex-row items-center space-y-4 md:space-y-0 md:space-x-8">
                <a className="flex-shrink-0">
                    <img src={Max.src} className="w-40 h-auto object-cover rounded-full" alt="Max" />
                </a>
                <div className="max-w-xl">
                    <h1 className="text-2xl font-bold text-gray-900">MAX</h1>
                    <h2 className="text-xl font-semibold text-gray-700"><b>O herói de integrações na sua empresa</b></h2>
                    <p className="text-gray-600 mt-2">
                    Max pode ser considerado um chutador de códigos e um defensor de desenvolvedores por onde passa.
                    </p>
                    <p className="text-gray-600 mt-2">
                    Ele representa integração, e combina força e velocidade para transportar dados e códigos para integrações mais rápidas. Seu trabalho é conectar todos os mundos: aplicativos, dados e dispositivos para uma união digna de herói.
                    </p>
                </div>
                </div>

                <div className="flex flex-col md:flex-row items-center space-y-4 md:space-y-0 md:space-x-8">
                <a className="flex-shrink-0">
                    <img src={Ruth.src} className="w-40 h-auto object-cover rounded-full" alt="Ruth" />
                </a>
                <div className="max-w-xl">
                    <h1 className="text-2xl font-bold text-gray-900">RUTH</h1>
                    <h2 className="text-xl font-semibold text-gray-700"><b>A sua conselheira favorita</b></h2>
                    <p className="text-gray-600 mt-2">
                    Ruth é ágil e protetora que não aceita "não" como resposta quando se trata de ajudar seus clientes e parceiros a terem sucesso.
                    </p>
                    <p className="text-gray-600 mt-2">
                    Ela personifica os Consultores da Salesforce, ajudando empresas de todos os tamanhos a implantar soluções para um sucesso nunca visto antes.
                    </p>
                </div>
                </div>

                <div className="flex flex-col md:flex-row items-center space-y-4 md:space-y-0 md:space-x-8">
                <a className="flex-shrink-0">
                    <img src={Blaze.src} className="w-40 h-auto object-cover rounded-full" alt="Ruth" />
                </a>
                <div className="max-w-xl">
                    <h1 className="text-2xl font-bold text-gray-900">BLAZE</h1>
                    <h2 className="text-xl font-semibold text-gray-700"><b>Seu guia para alcançar o customer success</b></h2>
                    <p className="text-gray-600 mt-2">
                    Blaze é o seu guia confiável na trilha dos negócios. Ela representa o sucesso do cliente e conhece todos os caminhos para ajudar você a conquistar o seu espaço.
                    </p>
                    <p className="text-gray-600 mt-2">
                    Blaze sabe que o caminho pode conter armadilhas e obstáculos, 
                        por isso ela conhece tudo e você pode confiar de ter ao lado na sua jornada com a Salesforce.
                    </p>
                </div>
                </div>

                <div className="flex flex-col md:flex-row items-center space-y-4 md:space-y-0 md:space-x-8">
                <a className="flex-shrink-0">
                    <img src={Koa.src} className="w-40 h-auto object-cover rounded-full" alt="Ruth" />
                </a>
                <div className="max-w-xl">
                    <h1 className="text-2xl font-bold text-gray-900">Koa</h1>
                    <h2 className="text-xl font-semibold text-gray-700"><b>O melhor amigo das pequenas empresas</b></h2>
                    <p className="text-gray-600 mt-2">
                    Koa, o Cachorro, representa amor e longevidade, além de Salesforce Essentials para Pequenas Empresas. 
                            Como um bom cachorro, ele ama a todos e sempre arruma tempo para trabalhar e se divertir.
                    </p>
                    <p className="text-gray-600 mt-2">
                    A maior alegria de Koa é arrancar sorrisos, e sempre será seu fiel companheiro.
                             Faça o que você ama e conte com o seu melhor amigo para estar sempre ao seu lado.
                    </p>
                </div>
                </div>
            </section>
            </nav>

    </>
)
}