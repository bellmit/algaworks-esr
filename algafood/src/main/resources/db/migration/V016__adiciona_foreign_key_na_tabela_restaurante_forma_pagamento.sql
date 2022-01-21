alter table restaurante_forma_pagamento
    add constraint fk_rest_forma_pagto_forma_pagto
        foreign key (forma_pagamento_id) references forma_pagamento (id);

alter table restaurante_forma_pagamento
    add constraint fk_rest_forma_pagto_restaurante
        foreign key (restaurante_id) references restaurante (id);