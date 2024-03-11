import multiprocessing as mp

print('Processadores/núcleos: ', mp.cpu_count())


def quadrado(x):
    return x*x
