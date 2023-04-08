

def print_line(size):
    print(size*"*")


def print_id(id, size):
    quantity_symbols = 5 + len(id)
    print(f"*ID:{id}" + (size-quantity_symbols)*" " + "*")


def print_head(head, size):
    text_field = size - 8
    middle = round(text_field/2)
    for i in range(0, len(head), text_field):
        if len(head[i:i+text_field]) == text_field:
            print(f"*   {head[i:i+text_field]}" + "   *")
        else:
            quan_symb_befo_head = round(middle - len(head[i:i+text_field])/2)
            quan_symb_afte_head = text_field - (quan_symb_befo_head + len(head[i:i+text_field]))
            print(f"*   " + quan_symb_befo_head*" " + f"{head[i:i+text_field]}" + quan_symb_afte_head*" " + "   *")
            print(f"*   " + text_field*"_" + "   *")

def print_body(body, size):
    text_field = size - 4
    for i in range(0, len(body), text_field):
        if len(body[i:i+text_field]) == text_field:
            print(f"* {body[i:i+text_field]}" + " *")
        else:
            print(f"* {body[i:i+text_field]}" + (text_field-len(body[i:i+text_field]))*" " + " *")

def print_date(date, size):
    quantity_symbols = len(date) + 2
    print("*" + (size - quantity_symbols)*" " + f"{date}*")

def print_time(time, size):
    quantity_symbols = len(time) + 2
    print("*" + (size - quantity_symbols)*" " + f"{time}*")


def print_all_notes(data):
    dict_notes = data["Notes"].keys()
    size = 50
    for i in dict_notes:
        note = data["Notes"][i]
        print_line(size)
        print_id(i, size)
        print_line(size)
        print_head(note["head"], size)
        print_body(note["body"], size)
        print_line(size)
        print_date(note["date"], size)
        print_time(note["time"], size)
        print_line(size)
        print()

def print_notes_for_date(data, find_date):
    count_of_matches = 0
    dict_notes = data["Notes"].keys()
    size = 50
    for i in dict_notes:
        note = data["Notes"][i]
        if note["date"] == find_date:
            print_line(size)
            print_id(i, size)
            print_line(size)
            print_head(note["head"], size)
            print_body(note["body"], size)
            print_line(size)
            print_date(note["date"], size)
            print_time(note["time"], size)
            print_line(size)
            print()
            count_of_matches += 1
    if count_of_matches == 0:
        print("Совпадения не найдены!")
