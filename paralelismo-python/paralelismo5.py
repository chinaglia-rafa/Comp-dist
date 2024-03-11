import multiprocessing as mp
from multiprocessing import current_process
import time


def quadrado(x):
    nome = current_process().name
    print(f'Processo atual: {nome} | {x}² = {x*x}')
    return x*x


def principal():

    print('Núcleos: ', mp.cpu_count())

    pool = mp.Pool(processes=mp.cpu_count())

    inicio = time.time()

    print(pool.map(quadrado, range(2 * mp.cpu_count())))
    pool.close()
    pool.join()

    fim = time.time()

    print('\nTempo transcorrido: ', fim - inicio)


if __name__ == '__main__':
    principal()
