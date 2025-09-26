"use client"
import { useEffect, useState } from "react";
import dashboard from "./../../../public/assets/dashboard.png"

export default function colaborador() {
  const [selectedOption, setSelectedOption] = useState("option1");

  interface item {
    id: number;
    name: string;
    email: string;
    cargo: string;
    tipoEmpresa: string;
    setor: string;
    dataContato: Date;
    probabilidadeContratacao: number;
  }

  const [data, setData] = useState<item[]>([]);

  const getData = async () => {
    try {
      const response = await fetch("http://localhost:8080/trailfinder/todos", {
        method: 'GET',
        headers: {
          'Content-Type': 'application/json'
        },
      });

      if (!response.ok) {
        throw new Error('Network response was not ok');
      }

      const data = await response.json();
      
      // Ordena os dados de forma decrescente com base em probabilidadeContratacao
      const sortedData = data.sort((a: item, b: item) => b.probabilidadeContratacao - a.probabilidadeContratacao);

      setData(sortedData);

      const formattedData = data.map((item: item) => ({
        ...item,
        dataContato: new Date(item.dataContato),
      }));
    
      setData(formattedData);
    } catch (error) {
      console.log('Fetch error:', error);
    }
  };

  useEffect(() => {
    getData();
  }, []);




  return (
    <div className="flex">
      <div className="w-56 border-r-2 border-black p-5">
        <ul className="space-y-4">
          <li className={`cursor-pointer ${selectedOption === "option1" ? "font-bold" : ""}`}
              onClick={() => setSelectedOption("option1")}>Formulários</li>

          <li className={`cursor-pointer ${selectedOption === "option2" ? "font-bold" : ""}`}
              onClick={() => setSelectedOption("option2")}>Dashboard</li>
        </ul>
      </div>

      <div className="p-5 flex-1">
        {selectedOption === "option1" ? (
          <div>
            <h1 className="flex justify-center text-gray-800 font-extrabold text-xl mb-6">FORMULÁRIOS</h1>
            <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4 justify-center">
              {data.map((item) => (
                <div key={item.id} className="flex flex-col justify-center">
                  <div className="p-5 bg-gray-300 flex flex-col rounded-lg border-2 border-gray-800 shadow-[8px_6px_0px_0px] shadow-gray-800">
                    <p className="text-gray-800 font-extrabold text-xl">{item.name}</p>
                    <div className="flex justify-between">
                    <p className="text-gray-500 font-semibold text-sm">{item.dataContato.toLocaleDateString()}</p>
                      <h1 className="text-gray-800 font-extrabold text-sm">{item.email}</h1>
                      <p className="text-gray-800 font-extrabold text-xl mt-[-4px]">{item.probabilidadeContratacao}%</p>
                    </div>
                    <div className="flex justify-between">
                      <p className="text-gray-500 font-semibold text-sm">{item.cargo}</p>
                      <p className="text-gray-500 font-semibold text-sm">{item.tipoEmpresa}</p>
                      <p className="text-gray-500 font-semibold text-sm">{item.setor}</p>
                    </div>
                  </div>
                </div>
              ))}
            </div>
          </div>
        ) : (
          <div className="flex flex-col justify-center">
            <h1 className="text-xl font-bold flex justify-center mb-6">DASHBOARD</h1>
            <img src={dashboard.src} className="flex justify-center"/>
          </div>
        )}
      </div>
    </div>
  );
}
