from datetime import datetime

from controller import controller as cn
__package__

def run():
    while (True):
        command = input("Введите команду(для вызова справки введите HELP):")
        match command.upper():
            case "EXIT":
                return
            case "CREATE":
                create_note()
            case "SHOW":
                show_list()
            case "FILTER":
                show_list_with_date_filter()
            case "UPDATE":
                update_note()
            case "DELETE":
                delete_note()
            case "HELP":
                give_help()
            case _:
                print("NOT FOUND")

def create_note():
    id = 0
    
    head = input("Введите заголовок:")
    body = input("Введите текст:")
    now = datetime.now()
    date = now.strftime("%d.%m.%Y")
    time = now.strftime("%H:%M:%S")
    cn.add_note(id, head, body, date, time)

def show_list():
    cn.show_all_note()

def show_list_with_date_filter():

    find_date = input("Введите дату в формате DD.MM.YYYY:")
    cn.show_note_for_date(find_date)

def delete_note():
    show_list()
    id = input("Введите ID заметки для удаления:")
    cn.delete_note(id)

def update_note():
    id = input("Введите ID заметки для обновления:")
    head = input("Введите заголовок:")
    body = input("Введите текст:")
    now = datetime.now()
    date = now.strftime("%d.%m.%Y")
    time = now.strftime("%H:%M:%S")
    cn.update_note(id, head, body, date, time)

def give_help():
    print("Приветсвую, данное приложение управляется приведенными ниже командами из консоли, регистр не важен:")
    print("- для создания заметки воспользуйтесь командой CREATE")
    print("- для просмотра всех заметок воспользуйтесь командой SHOW")
    print("- для просмотра заметок за определенную дату воспользуйтесь командой FILTER")
    print("- для редактирования заметки воспользуйтесь командой UPDATE")
    print("- для удаления заметки воспользуйтесь командой DELETE")
    print("Приятного пользования!")
