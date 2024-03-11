from multiprocessing import Process, Value
import os


def troca(a, b):
    print(f'PPID: ', os.getppid())  # parent process ID
    print(f' PID: ', os.getpid())  # process ID
    aux = a.value
    a.value = b.value
    b.value = aux


def principal():
    a = Value('d', 11.1)
    b = Value('d', 22.2)

    print('a antes: ', a.value)
    print('b antes: ', b.value)

    processo = Process(target=troca, args=(a, b))
    processo.start()
    processo.join()

    print(f'a depois: { a.value }')
    print(f'b depois: { b.value }')


if __name__ == '__main__':
    principal()
