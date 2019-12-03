import { PizzaStatus } from './pizza-status';
import { Message } from './message';

export interface Pizza {
    id: number;
    description: string;
    iningredient: string;
    title: string;
    status: PizzaStatus;
    createdAt: Date;
    modifiedAt: Date;
    messages: Message[];
}
