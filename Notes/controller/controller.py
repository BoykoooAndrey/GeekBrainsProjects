__package__
from model.note import Note
from repository import repository as rep
from view import viewer as vi



def array_id_s():
    data = rep.get_all_notes()
    if len(data) > 0:
        return (data["Notes"]).keys()
    else:
        return []

def search_next_id(keys_id_s):
    
    array_id_s = []
    for i in keys_id_s:
        array_id_s.append(int(i))
    if len(array_id_s) > 0:
        for i in range(len(array_id_s)):
            if i != array_id_s[i] - 1:
                return i + 1
        return array_id_s[-1] + 1
        
    else:
        return 1

def add_note(id, head, body, date, time):
    id = int(search_next_id(array_id_s()))
    note = Note(id, head, body, date, time)
    rep.add_note(note)

def show_all_note():
    data = rep.get_all_notes()
    vi.print_all_notes(data)

def show_note_for_date(find_date):
    data = rep.get_all_notes()
    vi.print_notes_for_date(data, find_date)

def delete_note(id):
    rep.dell_note(id)

def update_note(id, head, body, date, time):
    id_s = array_id_s()
    if len(id_s) > 0:
        if id in id_s:
            note = Note(id, head, body, date, time)
            rep.update_note(note)
            return
    print("ID not found")

