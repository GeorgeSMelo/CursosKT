import tkinter as tk
from tkinter import ttk, messagebox

# Lista para almacenar las actividades localmente
activities = []

# Función para agregar una nueva actividad
def add_activity():
    name = name_entry.get()
    category = category_entry.get()
    estimated_time = estimated_time_entry.get()

    if not name or not category or not estimated_time:
        messagebox.showwarning("Advertencia", "Todos los campos son obligatorios.")
        return

    try:
        # Crear un nuevo registro de actividad
        new_activity = {
            "id": len(activities) + 1,
            "name": name,
            "category": category,
            "estimated_time": int(estimated_time),
            "real_time": 0
        }
        # Guardar la actividad en la lista
        activities.append(new_activity)
        messagebox.showinfo("Éxito", "Actividad agregada con éxito.")
        update_table()  # Actualizar la tabla
    except ValueError:
        messagebox.showerror("Error", "El tiempo estimado debe ser un número.")

# Función para actualizar la tabla con los datos locales
def update_table():
    for row in table.get_children():
        table.delete(row)
    for activity in activities:
        table.insert("", "end", values=(
            activity.get("id"),
            activity.get("name"),
            activity.get("category"),
            activity.get("estimated_time"),
            activity.get("real_time")
        ))

# Configuración de la ventana principal
root = tk.Tk()
root.title("Gestión de Actividades Local")
root.geometry("1050x400")

# Marco superior para agregar actividades
frame_top = tk.Frame(root)
frame_top.pack(pady=10)

tk.Label(frame_top, text="Nombre:").grid(row=0, column=0, padx=5)
name_entry = tk.Entry(frame_top)
name_entry.grid(row=0, column=1, padx=5)

tk.Label(frame_top, text="Categoría:").grid(row=0, column=2, padx=5)
category_entry = tk.Entry(frame_top)
category_entry.grid(row=0, column=3, padx=5)

tk.Label(frame_top, text="Tiempo Estimado (min):").grid(row=0, column=4, padx=5)
estimated_time_entry = tk.Entry(frame_top)
estimated_time_entry.grid(row=0, column=5, padx=5)

add_button = tk.Button(frame_top, text="Agregar Actividad", command=add_activity)
add_button.grid(row=0, column=6, padx=5)

# Tabla para mostrar las actividades
columns = ("ID", "Nombre", "Categoría", "Tiempo Estimado", "Tiempo Real")
table = ttk.Treeview(root, columns=columns, show="headings", height=15)
table.heading("ID", text="ID")
table.heading("Nombre", text="Nombre")
table.heading("Categoría", text="Categoría")
table.heading("Tiempo Estimado", text="Tiempo Estimado")
table.heading("Tiempo Real", text="Tiempo Real")
table.pack(fill="both", expand=True, padx=10, pady=10)

# Inicializar la tabla vacía
update_table()

root.mainloop()
